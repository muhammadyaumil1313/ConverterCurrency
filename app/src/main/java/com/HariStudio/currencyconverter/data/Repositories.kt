package com.HariStudio.currencyconverter.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repositories @Inject constructor(remoteDataSource: RemoteDataSource) {
    val remote = remoteDataSource
}