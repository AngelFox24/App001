package com.mrpro.app001

import com.google.gson.annotations.SerializedName

data class ProfileDotaModel(
    @SerializedName("tracked_until") val idDota2: Int,
    @SerializedName("solo_competitive_rank") val SoloRanketMmr: Int,
    @SerializedName("rank_tier") val medalla: Int,
    @SerializedName("profile") val profileDetails: ProfilePlayer,
    @SerializedName("mmr_estimate") val mmrEstimado: MmrEstimado,
    @SerializedName("leaderboard_rank") val clasificacionContinente: Int = 0,
    @SerializedName("competitive_rank") val ranketCompetitivo: Int,
)

data class ProfilePlayer(
    @SerializedName("account_id") val idDotero: Int,
    @SerializedName("personaname") val apodoDotero: String,
    @SerializedName("name") val nombrePersona: String,
    @SerializedName("plus") val dotaPlus: Boolean,
    @SerializedName("cheese") val queso: Int,
    @SerializedName("steamid") val idSteam: String,
    @SerializedName("avatar") val fotoPequenio: String,
    @SerializedName("avatarmedium") val fotoMediano: String,
    @SerializedName("avatarfull") val fotoGrande: String,
    @SerializedName("profileurl") val urlPerfilSteam: String,
    @SerializedName("last_login") val ultimaConexion: String,
    @SerializedName("loccountrycode") val servidorJuega: String,
    @SerializedName("is_contributor") val contribuye: Boolean,
)

data class MmrEstimado(@SerializedName("estimate") val estimadoMmr: Int)