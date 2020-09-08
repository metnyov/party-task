package com.github.metnyov.party.data.api

import android.content.res.AssetManager
import com.github.metnyov.party.data.entity.NwParty
import com.github.metnyov.party.data.entity.NwPartyDetails
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException

class MockAppApi(
    private val moshi: Moshi,
    private val assetManager: AssetManager
) : AppApi {

    override fun getPartyList(): List<NwParty> {
        val type = Types.newParameterizedType(List::class.java, NwParty::class.java)
        val adapter = moshi.adapter<List<NwParty>>(type)
        val jsonString = getJsonDataFromAsset(PARTY_JSON)

        return adapter.fromJson(jsonString ?: "[]") ?: emptyList()
    }

    override fun getPartyDetails(partyId: Long): NwPartyDetails? {
        val type = Types.newParameterizedType(List::class.java, NwPartyDetails::class.java)
        val adapter = moshi.adapter<List<NwPartyDetails>>(type)
        val jsonString = getJsonDataFromAsset(PARTY_DETAILS_JSON)
        val items = adapter.fromJson(jsonString ?: "[]") ?: emptyList()

        return items.find { it.id == partyId }
    }

    private fun getJsonDataFromAsset(fileName: String): String? {
        return try {
            assetManager.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
    }

    companion object {
        private const val PARTY_JSON = "party.json"
        private const val PARTY_DETAILS_JSON = "party_details.json"
    }
}