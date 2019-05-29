package com.volkovmedia.supermunchkin.presentation

import com.volkovmedia.feature.munchkinlist.presentation.MunchkinListNavigator
import com.volkovmedia.feature.teamedit.presentation.TeamEditNavigator
import com.volkovmedia.feature.teamlist.presentation.TeamListNavigator
import com.volkovmedia.supermunchkin.R
import com.volkovmedia.supermunchkin.presentation.base.BaseActivity
import com.volkovmedia.supermunchkin.presentation.navigation.ScreenDestination.*

class MunchkinActivity : BaseActivity(
    screenLayoutResource = R.layout.activity_munchkin,
    frameLayoutResource = R.id.main_frame,
    startScreen = TeamList
), TeamListNavigator, TeamEditNavigator, MunchkinListNavigator {

    override fun navigateToTeam(teamId: Long) = navigateTo(MunchkinList(teamId))

    override fun navigateToTeamCreate() = navigateTo(TeamEdit())

    override fun navigateToTeamEdit(teamId: Long) = navigateTo(TeamEdit(teamId))

    override fun navigateToBattle() = navigateTo(Battle)

    override fun navigateToMunchkinEdit(munchkinId: Long) = navigateTo(MunchkinEdit(munchkinId))

}