package com.peanutbutter1001.android_base_template.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.peanutbutter1001.android_base_template.ui.screens.DetailScreen
import com.peanutbutter1001.android_base_template.ui.screens.HomeScreen

/**
 * 앱 전체 네비게이션 그래프 (Navigation 3).
 *
 * Nav2 의 NavController 대신, 백스택(rememberNavBackStack)을 직접 소유하고
 * NavDisplay 에 넘긴다. 이동은 backStack.add(...), 뒤로가기는 백스택에서 제거.
 * entryProvider 의 entry<T> 블록이 각 키를 실제 화면으로 매핑한다.
 */
@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            // 화면별 저장 상태 유지 + ViewModel 을 각 목적지에 스코핑
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    onItemClick = { itemId -> backStack.add(Detail(itemId = itemId)) },
                )
            }
            entry<Detail> { key ->
                DetailScreen(
                    itemId = key.itemId,
                    onBack = { backStack.removeLastOrNull() },
                )
            }
        },
    )
}
