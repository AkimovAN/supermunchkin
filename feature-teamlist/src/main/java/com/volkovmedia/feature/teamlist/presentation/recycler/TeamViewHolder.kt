package com.volkovmedia.feature.teamlist.presentation.recycler

import android.view.View
import com.volkovmedia.component.common.util.format
import com.volkovmedia.component.common.util.onClick
import com.volkovmedia.component.common.util.onLongClick
import com.volkovmedia.component.common.view.recycler.base.BindableViewHolder
import com.volkovmedia.component.coredata.model.dto.TeamDto
import com.volkovmedia.component.coredata.model.entity.Munchkin
import kotlinx.android.synthetic.main.teamslist_item.*

internal class TeamViewHolder(
    itemView: View,
    private val onClick: (Int) -> Unit,
    private val onLongClick: (Int) -> Unit
) : BindableViewHolder<TeamDto>(itemView) {

    init {
        teamslist_item_card.onClick = { if (hasPosition) onClick.invoke(adapterPosition) }
        teamslist_item_card.onLongClick = { if (hasPosition) onLongClick.invoke(adapterPosition) }
    }

    override fun bind(item: TeamDto) {
        val team = item.team

        teamslist_item_name.text = team.name
        teamslist_item_id.text = team.id.toString()
        teamslist_item_participants.text = item.participants.getListString()
        teamslist_item_date.text = team.lastGameDate.format()
    }

    private fun List<Munchkin>.getListString(): String {
        return if (isEmpty()) return "Участников ещё нет"
        else joinToString(separator = ", ") { it.name }
    }

}