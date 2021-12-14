package com.greentowersolution.driptap.feature_drip.domain.use_case

import kotlin.math.roundToLong

class ComputeDrips {

    private var lastTapTime: Long = 0
    private var nextTapTime: Long = 0
    private var intervalTime: Long = 0
    private var dripsPerMinute: Long = 0

    operator fun invoke(): Long {
        val timeNow = System.currentTimeMillis()

        if (lastTapTime > 0) {

            nextTapTime = timeNow

            intervalTime = nextTapTime - lastTapTime

            lastTapTime = nextTapTime

            dripsPerMinute = (60000 / intervalTime.toDouble()).roundToLong()
        }

        if (nextTapTime == 0L || this.lastTapTime == 0L) {
            this.lastTapTime = timeNow
        }

        return dripsPerMinute
    }
}
