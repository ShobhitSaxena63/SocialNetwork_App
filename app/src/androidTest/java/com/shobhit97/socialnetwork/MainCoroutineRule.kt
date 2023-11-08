package com.shobhit97.socialnetwork
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

//define own test rule

@OptIn(ExperimentalCoroutinesApi::class)
class MainCoroutineRule(
    private val testDispatcher: TestDispatcher = StandardTestDispatcher(),
    private val scope: TestScope = TestScope(testDispatcher)
):TestWatcher() {


    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }

//    fun runBlockingTest(block: suspend () -> Unit) {
//        scope.runTest {
//            block()
//        }
//    }
}