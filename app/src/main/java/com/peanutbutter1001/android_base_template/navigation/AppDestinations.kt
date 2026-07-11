package com.peanutbutter1001.android_base_template.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * Navigation 3 라우트(키) 정의.
 *
 * Nav3 에서는 각 목적지를 NavKey 를 구현한 @Serializable 클래스로 선언한다.
 * @Serializable + NavKey 여야 rememberNavBackStack 이 구성 변경/프로세스 종료
 * 후에도 백스택을 복원할 수 있다.
 *
 * 인자가 없는 화면은 data object, 인자가 있는 화면은 data class 로 정의한다.
 */

@Serializable
data object Home : NavKey

@Serializable
data class Detail(val itemId: Int) : NavKey
