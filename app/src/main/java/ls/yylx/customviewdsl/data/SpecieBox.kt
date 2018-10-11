package ls.yylx.customviewdsl.data


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique


import io.objectbox.converter.PropertyConverter

data class SpeciesBoxBack(
        var offset: Int = 0,
        var limit: Int = 0,
        var endOfRecords: Boolean = false,
        var results: List<SpecieBox> = listOf()
)

@Entity
data class SpecieBox(
        @Id(assignable = true) var key: Long = 0,//自定义id
        @Unique var nubKey: Int = 0,
        @Unique var nameKey: Int = 0,
        var taxonID: String = "",
        var sourceTaxonKey: Int = 0,
        var kingdom: String = "",
        var kingdomKey: Int = 0,
        var datasetKey: String = "",
        var constituentKey: String = "",
        var scientificName: String = "",
        var canonicalName: String = "",
        var authorship: String = "",
        var nameType: String = "",
        var rank: String = "",
        var origin: String = "",
        var taxonomicStatus: String = "",
        @Convert(converter = StringsConverter::class, dbType = String::class)
        var nomenclaturalStatus: List<String> = listOf(),
        var remarks: String = "",
        var numDescendants: Int = 0,
        var lastCrawled: String = "",
        var lastInterpreted: String = "",
        @Convert(converter = StringsConverter::class, dbType = String::class)
        var issues: List<String> = listOf(),
        var synonym: Boolean = false,
        var phylum: String = "",
        var phylumKey: Int = 0,
        var parentKey: Int = 0,
        var parent: String = "",
        var acceptedKey: Int = 0,
        var accepted: String = ""
)

val gson = Gson()
val listType = object : TypeToken<List<String>>() {}.type


class StringsConverter : PropertyConverter<List<String>, String> {
    override fun convertToDatabaseValue(entityProperty: List<String>?): String {

        return gson.toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): List<String> {

        return gson.fromJson(databaseValue, listType)
    }

}
