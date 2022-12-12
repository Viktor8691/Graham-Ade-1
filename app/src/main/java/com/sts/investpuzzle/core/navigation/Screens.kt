package com.sts.investpuzzle.core.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sts.investpuzzle.features.friends.friend_profile.FriendProfileScreen
import com.sts.investpuzzle.features.main_fragment.MainScreen
import com.sts.investpuzzle.features.messages.MessageScreen
import com.sts.investpuzzle.features.movers.MoverScreen
import com.sts.investpuzzle.features.news.NewsScreen
import com.sts.investpuzzle.features.notifications.NotificationScreen
import com.sts.investpuzzle.features.profile.ProfileScreen
import com.sts.investpuzzle.features.profile.edit_profile.EditProfileScreen
import com.sts.investpuzzle.features.profile.followers.FollowerScreen
import com.sts.investpuzzle.features.profile.following.FollowingScreen
import com.sts.investpuzzle.features.profile.holdings.HoldingScreen
import com.sts.investpuzzle.features.profile.myprofile.MyProfileScreen
import com.sts.investpuzzle.features.profile.myprofile.badge.BadgeScreen
import com.sts.investpuzzle.features.profile.myprofile.groups.GroupScreen
import com.sts.investpuzzle.features.profile.myprofile.groups.add_participants.AddParticipantScreen
import com.sts.investpuzzle.features.profile.myprofile.groups.create_group.CreateGroupScreen
import com.sts.investpuzzle.features.profile.myprofile.posts.MyPostScreen
import com.sts.investpuzzle.features.profile.myprofile.portfolio.PortfolioScreen
import com.sts.investpuzzle.features.ranking.RankingScreen
import com.sts.investpuzzle.features.search.SearchScreen
import com.sts.investpuzzle.features.setting.SettingScreen
import com.sts.investpuzzle.features.stocks.StockScreen
import com.sts.investpuzzle.features.stocks.buy.BuyStockScreen
import com.sts.investpuzzle.features.stocks.buy.buy_success.BuySuccessScreen
import com.sts.investpuzzle.features.stocks.stock_detail.StockDetailScreen
import com.sts.investpuzzle.features.user_management.forgot_password.ForgotPwdScreen
import com.sts.investpuzzle.features.user_management.input_otp.InputOTPScreen
import com.sts.investpuzzle.features.user_management.input_user_detail.InputUserInfoScreen
import com.sts.investpuzzle.features.user_management.reset_password.ResetPasswordScreen
import com.sts.investpuzzle.features.user_management.reset_pwd_success.ResetPwdSuccessScreen
import com.sts.investpuzzle.features.user_management.signin.SignInScreen
import com.sts.investpuzzle.features.user_management.signup.SignupScreen
import com.sts.investpuzzle.features.user_management.start.StartupScreen
import com.sts.investpuzzle.features.user_management.welcome_signup.WelcomeSignupScreen

object Screens {
    fun getStartupScreen() = FragmentScreen{StartupScreen()}
    fun getSignInScreen() = FragmentScreen{SignInScreen()}
    fun getSignupScreen() = FragmentScreen{SignupScreen()}
    class GetInputOTPScreen (private val bundle : Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = InputOTPScreen()
            screen.arguments = bundle
            return screen
        }
    }
    fun getForgotPwdScreen() = FragmentScreen{ForgotPwdScreen()}
    class GetInputUserInfoScreen (private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = InputUserInfoScreen()
            screen.arguments = bundle
            return screen
        }
    }
    fun getWelcomeSignupScreen() = FragmentScreen{WelcomeSignupScreen()}
    fun getStockScreen() = StockScreen()
    fun getNewsScreen() = NewsScreen()
    fun getRankingScreen() = RankingScreen()
    fun getMoverScreen() = MoverScreen()
    fun getProfileScreen() = ProfileScreen()
    class GetResetPasswordScreen(private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = ResetPasswordScreen()
            screen.arguments = bundle
            return screen
        }
    }
    fun getResetPwdSuccessScreen() = FragmentScreen{ResetPwdSuccessScreen()}
    fun getMyProfileScreen() = MyProfileScreen()
    fun getSearchScreen() = SearchScreen()
    fun getPortfolioScreen() = PortfolioScreen()
    fun getGroupScreen() = GroupScreen()
    fun getMyForumScreen() = MyPostScreen()
    fun getBadgeScreen() = BadgeScreen()
    fun getHoldingScreen() = HoldingScreen()
    fun getFollowingScreen() = FollowingScreen()
    fun getFollowersScreen() = FollowerScreen()
    fun getMainScreen() = FragmentScreen{MainScreen()}
    fun getSettingScreen() = SettingScreen()
    fun getMessageScreen() = MessageScreen()
    fun getNotificationScreen() = NotificationScreen()
    fun getCreateGroupScreen() = FragmentScreen{CreateGroupScreen()}
    fun getAddParticipantScreen() = FragmentScreen{AddParticipantScreen()}
    class GetStockDetailScreen(private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = StockDetailScreen()
            screen.arguments = bundle
            return screen
        }
    }
    class GetBuyStockScreen(private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = BuyStockScreen()
            screen.arguments = bundle
            return screen
        }
    }
    class GetBuySuccessScreen(private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = BuySuccessScreen()
            screen.arguments = bundle
            return screen
        }
    }
    fun getEditProfileScreen() = FragmentScreen{EditProfileScreen()}
    class GetFriendProfileScreen(private val bundle: Bundle) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            val screen = FriendProfileScreen()
            screen.arguments = bundle
            return screen
        }

    }
}