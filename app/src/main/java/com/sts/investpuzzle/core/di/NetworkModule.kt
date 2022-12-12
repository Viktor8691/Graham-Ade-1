package com.sts.investpuzzle.core.di

import com.sts.investpuzzle.core.data.network.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun provideGetStocksRepo(stocksRepositoryImp: StocksRepositoryImp) : StocksRepository

    @Binds
    abstract fun provideSignupRepository(signupRepositoryImp: AuthRepositoryImp) : AuthRepository

    @Binds
    abstract fun provideAccessoriesRepository(accessoriesRepositoryImp: AccessoriesRepositoryImp) : AccessoriesRepository

    @Binds
    abstract fun provideUpdateProfileRepository(updateProfileRepositoryImp: UpdateProfileRepositoryImp) : UpdateProfileRepository

    @Binds
    abstract fun provideSocialRepository(socialRepositoryImp: SocialRepositoryImp) : SocialRepository

    @Binds
    abstract fun provideFileUploadRepository(fileUploadRepoImp: FileUploadRepoImp) : FileUploadRepo

    @Binds
    abstract fun provideProfileReposotiry(profileRepoImp: ProfileRepoImp) : ProfileRepo

    @Binds
    abstract fun provideNotiRepository(notiRepoImp: NotiRepoImp) : NotiRepo
}