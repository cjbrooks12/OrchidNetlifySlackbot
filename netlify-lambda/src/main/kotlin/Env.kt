package com.caseyjbrooks.netlify


class EnvVar {
    private val _env = js("process.env")

    val firebaseSerivceAccountFile: dynamic = JSON.parse(_env.FIREBASE_SERVICE_ACCOUNT_FILE)
    val firebaseUrl: String = _env.FIREBASE_URL
    val slackAppToken: String = _env.SLACK_APP_TOKEN
    val slackBotToken: String = _env.SLACK_BOT_TOKEN
    val slackVerificationToken: String = _env.SLACK_VERIFICATION_TOKEN

}