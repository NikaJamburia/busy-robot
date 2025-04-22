package ge.nika

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.decodeFromStream
import ge.nika.mouse.Coordinates
import kotlinx.serialization.Serializable
import java.io.File

data object Config {

    lateinit var intellijExecutable: String
        private set

    lateinit var browserCommand: String
        private set

    lateinit var closeBrowserCommand: String
        private set

    lateinit var keyPressPauseRange: LongRange
        private set

    lateinit var tempDirectory: String
        private set

    lateinit var screenDimensions: Coordinates
        private set

    fun initFromYamlFile(configFilePath: String) {

        val dto = File(configFilePath).inputStream().use {
            Yaml.default.decodeFromStream<ConfigurationDto>(it)
        }

        intellijExecutable = dto.intellijExecutable
        browserCommand = dto.browserCommand
        closeBrowserCommand = dto.closeBrowserCommand
        keyPressPauseRange = dto.keyPressPauseRangeMin..dto.keyPressPauseRangeMax
        tempDirectory = dto.tempDirectory
        screenDimensions = Coordinates(dto.screenW.toDouble(), dto.screenH.toDouble())
    }

    @Serializable
    private data class ConfigurationDto(
        val intellijExecutable: String,
        val browserCommand: String,
        val closeBrowserCommand: String,
        val keyPressPauseRangeMin: Long,
        val keyPressPauseRangeMax: Long,
        val tempDirectory: String,
        val screenH: Int,
        val screenW: Int,
    )
}