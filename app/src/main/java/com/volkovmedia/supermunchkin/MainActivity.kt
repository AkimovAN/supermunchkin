package com.volkovmedia.supermunchkin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import com.volkovmedia.feature.munchkinlist.FRAGMENT_MUNCHKINLIST
import com.volkovmedia.feature.munchkinlist.presentation.MunchkinListNavigator
import com.volkovmedia.feature.teamedit.FRAGMENT_TEAMEDIT
import com.volkovmedia.feature.teamedit.presentation.TeamEditNavigator
import com.volkovmedia.feature.teamlist.FRAGMENT_TEAMLIST
import com.volkovmedia.feature.teamlist.presentation.TeamListNavigator
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(),
    TeamListNavigator,
    TeamEditNavigator,
    MunchkinListNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.transaction {
            add(R.id.container, get(FRAGMENT_TEAMLIST))
            addToBackStack(FRAGMENT_TEAMLIST)
        }
    }

    override fun navigateToTeam(teamId: Long) {
        supportFragmentManager.transaction {
            replace(R.id.container, get(FRAGMENT_MUNCHKINLIST) { parametersOf(teamId) })
            addToBackStack(FRAGMENT_MUNCHKINLIST)
        }
    }

    override fun navigateToTeamCreate() = navigateToTeamEditScreen(null)

    override fun navigateToTeamEdit(teamId: Long) = navigateToTeamEditScreen(teamId)

    override fun navigateToBattle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToMunchkinEdit(munchkinId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun navigateToTeamEditScreen(teamId: Long?) {
        supportFragmentManager.transaction {
            replace(R.id.container, get(FRAGMENT_TEAMEDIT) { parametersOf(teamId) })
            addToBackStack(FRAGMENT_TEAMEDIT)
        }
    }

}