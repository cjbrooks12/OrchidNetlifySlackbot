package com.eden.slackbot

import com.eden.orchid.api.OrchidContext
import com.eden.orchid.api.options.OptionsHolder
import com.eden.orchid.api.options.annotations.Option
import com.eden.orchid.api.theme.components.OrchidComponent
import com.eden.orchid.utilities.OrchidUtils
import javax.inject.Inject

class SlackConversationComponent
@Inject
constructor(
    context: OrchidContext
) : OrchidComponent(context, "slackConversation", 100) {

    @Option
    lateinit var users: List<SlackUser>

    @Option
    lateinit var messages: List<SlackMessage>

    override fun onPostExtraction() {
        val usersMap = users.associateBy({ it.name }, { it })
        messages.forEach {
            it.user = usersMap[it.from]!!
        }
    }

    override fun loadAssets() {
        addJs("assets/js/shadowComponents.js")
    }
}

class SlackUser : OptionsHolder {
    @Option
    lateinit var name: String
    @Option
    lateinit var icon: String

    fun iconIsExternal(): Boolean {
        return OrchidUtils.isExternal(icon)
    }
}

class SlackMessage : OptionsHolder {
    @Option
    lateinit var from: String
    @Option
    lateinit var text: String
    @Option
    lateinit var time: String

    lateinit var user: SlackUser
}