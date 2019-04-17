package com.volkovmedia.feature.teamlist.domain

import com.volkovmedia.coredata.model.dto.TeamDto
import com.volkovmedia.coredata.model.entity.Team
import io.reactivex.Completable
import io.reactivex.Observable

internal interface TeamListRepository {

    fun getTeams(): Observable<List<TeamDto>>

    fun putTeam(team: Team): Completable

    fun removeTeam(team: Team): Completable

}