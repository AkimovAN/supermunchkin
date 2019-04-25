package com.volkovmedia.feature.munchkinprofile.presentation.mvi

import com.volkovmedia.component.data.model.entity.Munchkin

internal sealed class MunchkinEditAction {

    object DataLoadingStarted : MunchkinEditAction()

    class ShowDataRequested(val munchkin: Munchkin) : MunchkinEditAction()

    class EnableSuperMunchkin(val enable: Boolean) : MunchkinEditAction()

    class EnableHalfBlood(val enable: Boolean) : MunchkinEditAction()

    class WrongDataInputted(val error: Throwable) : MunchkinEditAction()

    object DataSaved : MunchkinEditAction()

}