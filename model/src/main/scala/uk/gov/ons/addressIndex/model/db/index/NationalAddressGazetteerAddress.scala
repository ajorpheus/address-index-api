package uk.gov.ons.addressIndex.model.db.index


import scala.util.Try

/**
  * NAG Address DTO
  */
case class NationalAddressGazetteerAddress (
  uprn: String,
  postcodeLocator: String,
  addressBasePostal: String,
  latitude: String,
  longitude: String,
  easting: String,
  northing: String,
  organisation: String,
  legalName: String,
  classificationCode: String,
  usrn: String,
  lpiKey: String,
  paoText: String,
  paoStartNumber: String,
  paoStartSuffix: String,
  paoEndNumber: String,
  paoEndSuffix: String,
  saoText: String,
  saoStartNumber: String,
  saoStartSuffix: String,
  saoEndNumber: String,
  saoEndSuffix: String,
  level: String,
  officialFlag: String,
  streetDescriptor: String,
  townName: String,
  locality: String,
  lpiLogicalStatus: String,
  blpuLogicalStatus: String,
  source: String,
  usrnMatchIndicator: String,
  parentUprn: String,
  crossReference: String,
  streetClassification: String,
  multiOccCount: String,
  language: String,
  classScheme: String,
  localCustodianCode: String,
  localCustodianName: String,
  localCustodianGeogCode: String,
  rpc: String,
  nagAll: String
)

/**
  * NAF Address DTO companion object that also contains implicits needed for Elastic4s
  */
object NationalAddressGazetteerAddress {

  object Fields {

    /**
      * Document Fields
      */
    val uprn: String = "uprn"
    val postcodeLocator: String = "postcodeLocator"
    val addressBasePostal: String = "addressBasePostal"
    val easting: String = "easting"
    val northing: String = "northing"
    val organisation: String = "organisation"
    val legalName: String = "legalName"
    val classificationCode: String = "classificationCode"
    val usrn: String = "usrn"
    val lpiKey: String = "lpiKey"
    val paoText: String = "paoText"
    val paoStartNumber: String = "paoStartNumber"
    val paoStartSuffix: String = "paoStartSuffix"
    val paoEndNumber: String = "paoEndNumber"
    val paoEndSuffix: String = "paoEndSuffix"
    val saoText: String = "saoText"
    val saoStartNumber: String = "saoStartNumber"
    val saoStartSuffix: String = "saoStartSuffix"
    val saoEndNumber: String = "saoEndNumber"
    val saoEndSuffix: String = "saoEndSuffix"
    val level: String = "level"
    val officialFlag: String = "officialFlag"
    val streetDescriptor: String = "streetDescriptor"
    val townName: String = "townName"
    val locality: String = "locality"
    val lpiLogicalStatus: String = "lpiLogicalStatus"
    val blpuLogicalStatus: String = "blpuLogicalStatus"
    val source: String = "source"
    val usrnMatchIndicator: String = "usrnMatchIndicator"
    val parentUprn: String = "parentUprn"
    val crossReference: String = "crossReference"
    val streetClassification: String = "streetClassification"
    val multiOccCount: String = "multiOccCount"
    val location: String = "location"
    val language: String = "language"
    val classScheme: String = "classScheme"
    val localCustodianCode: String = "localCustodianCode"
    val localCustodianName: String = "localCustodianName"
    val localCustodianGeogCode: String = "localCustodianGeogCode"
    val rpc: String = "rpc"
    val nagAll: String = "nagAll"
  }

  def fromEsMap (nag: Map[String, AnyRef]): NationalAddressGazetteerAddress = {
    val filteredNag = nag.filter{ case (_, value) => value != null }

    val matchLocationRegex = """-?\d+\.\d+""".r
    val location = filteredNag.getOrElse(Fields.location, "").toString

    val Array(longitude, latitude) = Try(matchLocationRegex.findAllIn(location).toArray).getOrElse(Array("0", "0"))

    NationalAddressGazetteerAddress (
      uprn = filteredNag.getOrElse(Fields.uprn, "").toString,
      postcodeLocator = filteredNag.getOrElse(Fields.postcodeLocator, "").toString,
      addressBasePostal = filteredNag.getOrElse(Fields.addressBasePostal, "").toString,
      latitude = latitude,
      longitude = longitude,
      easting = filteredNag.getOrElse(Fields.easting, "").toString,
      northing = filteredNag.getOrElse(Fields.northing, "").toString,
      organisation = filteredNag.getOrElse(Fields.organisation, "").toString,
      legalName = filteredNag.getOrElse(Fields.legalName, "").toString,
      classificationCode = filteredNag.getOrElse(Fields.classificationCode, "").toString,
      usrn = filteredNag.getOrElse(Fields.usrn, "").toString,
      lpiKey = filteredNag.getOrElse(Fields.lpiKey, "").toString,
      paoText = filteredNag.getOrElse(Fields.paoText, "").toString,
      paoStartNumber = filteredNag.getOrElse(Fields.paoStartNumber, "").toString,
      paoStartSuffix = filteredNag.getOrElse(Fields.paoStartSuffix, "").toString,
      paoEndNumber = filteredNag.getOrElse(Fields.paoEndNumber, "").toString,
      paoEndSuffix = filteredNag.getOrElse(Fields.paoEndSuffix, "").toString,
      saoText = filteredNag.getOrElse(Fields.saoText, "").toString,
      saoStartNumber = filteredNag.getOrElse(Fields.saoStartNumber, "").toString,
      saoStartSuffix = filteredNag.getOrElse(Fields.saoStartSuffix, "").toString,
      saoEndNumber = filteredNag.getOrElse(Fields.saoEndNumber, "").toString,
      saoEndSuffix = filteredNag.getOrElse(Fields.saoEndSuffix, "").toString,
      level = filteredNag.getOrElse(Fields.level, "").toString,
      officialFlag = filteredNag.getOrElse(Fields.officialFlag, "").toString,
      streetDescriptor = filteredNag.getOrElse(Fields.streetDescriptor, "").toString,
      townName = filteredNag.getOrElse(Fields.townName, "").toString,
      locality = filteredNag.getOrElse(Fields.locality, "").toString,
      lpiLogicalStatus = filteredNag.getOrElse(Fields.lpiLogicalStatus, "").toString,
      blpuLogicalStatus = filteredNag.getOrElse(Fields.blpuLogicalStatus, "").toString,
      source = filteredNag.getOrElse(Fields.source, "").toString,
      usrnMatchIndicator = filteredNag.getOrElse(Fields.usrnMatchIndicator, "").toString,
      parentUprn = filteredNag.getOrElse(Fields.parentUprn, "").toString,
      crossReference = filteredNag.getOrElse(Fields.crossReference, "").toString,
      streetClassification = filteredNag.getOrElse(Fields.streetClassification, "").toString,
      multiOccCount = filteredNag.getOrElse(Fields.multiOccCount, "").toString,
      language = filteredNag.getOrElse(Fields.language, "").toString,
      classScheme = filteredNag.getOrElse(Fields.classScheme, "").toString,
      localCustodianCode = filteredNag.getOrElse(Fields.localCustodianCode, "").toString,
      localCustodianName = LocalCustodian.getLAName(filteredNag.getOrElse(Fields.localCustodianCode, "").toString),
      localCustodianGeogCode = LocalCustodian.getLACode(filteredNag.getOrElse(Fields.localCustodianCode, "").toString),
      rpc = filteredNag.getOrElse(Fields.rpc, "").toString,
      nagAll = filteredNag.getOrElse(Fields.nagAll, "").toString
    )
  }
}

case class LocalCustodian (custodians: Map[String,String])


object LocalCustodian {

  def getLAName(code: String): String = {

    val custKey = "N" + code
    if(custodians.contains(custKey)) {
      custodians(custKey)
    } else {
      custKey
    }

  }

  def getLACode(code: String): String = {

    val custKey = "C" + code
    if(custodians.contains(custKey)) {
      custodians(custKey)
    } else {
      custKey
    }

  }

  val custodians = Map(
    "N114" -> "BATH AND NORTH EAST SOMERSET",
    "C114" -> "E06000022",
    "N116" -> "BRISTOL CITY",
    "C116" -> "E06000023",
    "N119" -> "SOUTH GLOUCESTERSHIRE",
    "C119" -> "E06000025",
    "N121" -> "NORTH SOMERSET",
    "C121" -> "E06000024",
    "N230" -> "LUTON",
    "C230" -> "E06000032",
    "N235" -> "BEDFORD",
    "C235" -> "E06000055",
    "N240" -> "CENTRAL BEDFORDSHIRE",
    "C240" -> "E06000056",
    "N335" -> "BRACKNELL FOREST",
    "C335" -> "E06000036",
    "N340" -> "WEST BERKSHIRE",
    "C340" -> "E06000037",
    "N345" -> "READING",
    "C345" -> "E06000038",
    "N350" -> "SLOUGH",
    "C350" -> "E06000039",
    "N355" -> "WINDSOR AND MAIDENHEAD",
    "C355" -> "E06000040",
    "N360" -> "WOKINGHAM",
    "C360" -> "E06000041",
    "N405" -> "AYLESBURY VALE",
    "C405" -> "E07000004",
    "N410" -> "SOUTH BUCKS",
    "C410" -> "E07000006",
    "N415" -> "CHILTERN",
    "C415" -> "E07000005",
    "N425" -> "WYCOMBE",
    "C425" -> "E07000007",
    "N435" -> "MILTON KEYNES",
    "C435" -> "E06000042",
    "N505" -> "CAMBRIDGE",
    "C505" -> "E07000008",
    "N510" -> "EAST CAMBRIDGESHIRE",
    "C510" -> "E07000009",
    "N515" -> "FENLAND",
    "C515" -> "E07000010",
    "N520" -> "HUNTINGDONSHIRE",
    "C520" -> "E07000011",
    "N530" -> "SOUTH CAMBRIDGESHIRE",
    "C530" -> "E07000012",
    "N540" -> "CITY OF PETERBOROUGH",
    "C540" -> "E06000031",
    "N650" -> "HALTON",
    "C650" -> "E06000006",
    "N655" -> "WARRINGTON",
    "C655" -> "E06000007",
    "N660" -> "CHESHIRE EAST",
    "C660" -> "E06000049",
    "N665" -> "CHESHIRE WEST AND CHESTER",
    "C665" -> "E06000050",
    "N724" -> "HARTLEPOOL",
    "C724" -> "E06000001",
"N728" -> "REDCAR AND CLEVELAND",
"N734" -> "MIDDLESBROUGH",
"N738" -> "STOCKTON-ON-TEES",
"N835" -> "ISLES OF SCILLY",
"N840" -> "CORNWALL",
"N905" -> "ALLERDALE",
"N910" -> "BARROW-IN-FURNESS",
"N915" -> "CARLISLE",
"N920" -> "COPELAND",
"N925" -> "EDEN",
"N930" -> "SOUTH LAKELAND",
"N1005" -> "AMBER VALLEY",
"N1010" -> "BOLSOVER",
"N1015" -> "CHESTERFIELD",
"N1025" -> "EREWASH",
"N1030" -> "HIGH PEAK",
"N1035" -> "NORTH EAST DERBYSHIRE",
"N1040" -> "SOUTH DERBYSHIRE",
"N1045" -> "DERBYSHIRE DALES",
"N1055" -> "CITY OF DERBY",
"N1105" -> "EAST DEVON",
    "N1110" -> "EXETER",
    "C1110" -> "E07000041",
"N1115" -> "NORTH DEVON",
"N1125" -> "SOUTH HAMS",
"N1130" -> "TEIGNBRIDGE",
"N1135" -> "MID DEVON",
"N1145" -> "TORRIDGE",
"N1150" -> "WEST DEVON",
"N1160" -> "CITY OF PLYMOUTH",
"N1165" -> "TORBAY",
"N1210" -> "CHRISTCHURCH",
"N1215" -> "NORTH DORSET",
"N1225" -> "PURBECK",
"N1230" -> "WEST DORSET",
"N1235" -> "WEYMOUTH AND PORTLAND",
"N1240" -> "EAST DORSET",
"N1250" -> "BOURNEMOUTH",
"N1255" -> "POOLE",
"N1350" -> "DARLINGTON",
"N1355" -> "DURHAM",
"N1410" -> "EASTBOURNE",
"N1415" -> "HASTINGS",
"N1425" -> "LEWES",
"N1430" -> "ROTHER",
"N1435" -> "WEALDEN",
"N1445" -> "BRIGHTON AND HOVE",
"N1505" -> "BASILDON",
"N1510" -> "BRAINTREE",
"N1515" -> "BRENTWOOD",
"N1520" -> "CASTLE POINT",
"N1525" -> "CHELMSFORD",
"N1530" -> "COLCHESTER",
"N1535" -> "EPPING FOREST",
"N1540" -> "HARLOW",
"N1545" -> "MALDON",
"N1550" -> "ROCHFORD",
"N1560" -> "TENDRING",
"N1570" -> "UTTLESFORD",
"N1590" -> "SOUTHEND-ON-SEA",
"N1595" -> "THURROCK",
"N1605" -> "CHELTENHAM",
"N1610" -> "COTSWOLD",
"N1615" -> "FOREST OF DEAN",
"N1620" -> "GLOUCESTER",
"N1625" -> "STROUD",
"N1630" -> "TEWKESBURY",
"N1705" -> "BASINGSTOKE AND DEANE",
"N1710" -> "EAST HAMPSHIRE",
"N1715" -> "EASTLEIGH",
"N1720" -> "FAREHAM",
"N1725" -> "GOSPORT",
"N1730" -> "HART",
"N1735" -> "HAVANT",
"N1740" -> "NEW FOREST",
"N1750" -> "RUSHMOOR",
"N1760" -> "TEST VALLEY",
"N1765" -> "WINCHESTER",
"N1775" -> "CITY OF PORTSMOUTH",
"N1780" -> "CITY OF SOUTHAMPTON",
"N1805" -> "BROMSGROVE",
"N1820" -> "MALVERN HILLS",
"N1825" -> "REDDITCH",
"N1835" -> "WORCESTER",
"N1840" -> "WYCHAVON",
"N1845" -> "WYRE FOREST",
"N1850" -> "HEREFORDSHIRE",
"N1905" -> "BROXBOURNE",
"N1910" -> "DACORUM",
"N1915" -> "EAST HERTFORDSHIRE",
"N1920" -> "HERTSMERE",
"N1925" -> "NORTH HERTFORDSHIRE",
"N1930" -> "ST ALBANS",
"N1935" -> "STEVENAGE",
"N1940" -> "THREE RIVERS",
"N1945" -> "WATFORD",
"N1950" -> "WELWYN HATFIELD",
"N2001" -> "EAST RIDING OF YORKSHIRE",
"N2002" -> "NORTH EAST LINCOLNSHIRE",
"N2003" -> "NORTH LINCOLNSHIRE",
"N2004" -> "CITY OF KINGSTON UPON HULL",
"N2114" -> "ISLE OF WIGHT",
"N2205" -> "ASHFORD",
"N2210" -> "CANTERBURY",
"N2215" -> "DARTFORD",
"N2220" -> "DOVER",
"N2230" -> "GRAVESHAM",
"N2235" -> "MAIDSTONE",
"N2245" -> "SEVENOAKS",
"N2250" -> "SHEPWAY",
"N2255" -> "SWALE",
"N2260" -> "THANET DISTRICT",
"N2265" -> "TONBRIDGE AND MALLING",
"N2270" -> "TUNBRIDGE WELLS",
"N2280" -> "MEDWAY",
"N2315" -> "BURNLEY",
"N2320" -> "CHORLEY",
"N2325" -> "FYLDE",
"N2330" -> "HYNDBURN",
"N2335" -> "LANCASTER CITY",
"N2340" -> "PENDLE",
"N2345" -> "PRESTON",
"N2350" -> "RIBBLE VALLEY",
"N2355" -> "ROSSENDALE",
"N2360" -> "SOUTH RIBBLE",
"N2365" -> "WEST LANCASHIRE",
"N2370" -> "WYRE",
"N2372" -> "BLACKBURN",
"N2373" -> "BLACKPOOL",
"N2405" -> "BLABY",
"N2410" -> "CHARNWOOD",
"N2415" -> "HARBOROUGH",
"N2420" -> "HINCKLEY AND BOSWORTH",
"N2430" -> "MELTON",
"N2435" -> "NORTH WEST LEICESTERSHIRE",
"N2440" -> "OADBY AND WIGSTON",
"N2465" -> "CITY OF LEICESTER",
"N2470" -> "RUTLAND",
"N2505" -> "BOSTON",
"N2510" -> "EAST LINDSEY",
"N2515" -> "LINCOLN",
"N2520" -> "NORTH KESTEVEN",
"N2525" -> "SOUTH HOLLAND",
"N2530" -> "SOUTH KESTEVEN",
"N2535" -> "WEST LINDSEY",
"N2605" -> "BRECKLAND",
"N2610" -> "BROADLAND",
"N2615" -> "GREAT YARMOUTH",
"N2620" -> "NORTH NORFOLK",
"N2625" -> "NORWICH",
"N2630" -> "SOUTH NORFOLK",
"N2635" -> "KINGS LYNN AND WEST NORFOLK",
"N2705" -> "CRAVEN",
"N2710" -> "HAMBLETON",
"N2715" -> "HARROGATE",
"N2720" -> "RICHMONDSHIRE",
"N2725" -> "RYEDALE",
"N2730" -> "SCARBOROUGH",
"N2735" -> "SELBY",
"N2741" -> "YORK",
"N2805" -> "CORBY",
"N2810" -> "DAVENTRY",
"N2815" -> "EAST NORTHAMPTONSHIRE",
"N2820" -> "KETTERING",
"N2825" -> "NORTHAMPTON",
"N2830" -> "SOUTH NORTHAMPTONSHIRE",
"N2835" -> "WELLINGBOROUGH",
"N2935" -> "NORTHUMBERLAND",
"N3005" -> "ASHFIELD",
"N3010" -> "BASSETLAW",
"N3015" -> "BROXTOWE",
"N3020" -> "GEDLING",
"N3025" -> "MANSFIELD",
"N3030" -> "NEWARK AND SHERWOOD",
"N3040" -> "RUSHCLIFFE",
"N3060" -> "NOTTINGHAM CITY",
"N3105" -> "CHERWELL",
"N3110" -> "OXFORD",
"N3115" -> "SOUTH OXFORDSHIRE",
"N3120" -> "VALE OF WHITE HORSE",
"N3125" -> "WEST OXFORDSHIRE",
"N3240" -> "TELFORD",
"N3245" -> "SHROPSHIRE",
"N3305" -> "MENDIP",
"N3310" -> "SEDGEMOOR",
"N3315" -> "TAUNTON DEANE",
"N3320" -> "WEST SOMERSET",
"N3325" -> "SOUTH SOMERSET",
"N3405" -> "CANNOCK CHASE",
"N3410" -> "EAST STAFFORDSHIRE",
"N3415" -> "LICHFIELD",
"N3420" -> "NEWCASTLE-UNDER-LYME",
"N3425" -> "STAFFORD",
"N3430" -> "SOUTH STAFFORDSHIRE",
"N3435" -> "STAFFORDSHIRE MOORLANDS",
"N3445" -> "TAMWORTH",
"N3455" -> "CITY OF STOKE-ON-TRENT",
"N3505" -> "BABERGH",
"N3510" -> "FOREST HEATH",
"N3515" -> "IPSWICH",
"N3520" -> "MID SUFFOLK",
"N3525" -> "ST EDMUNDSBURY",
"N3530" -> "SUFFOLK COASTAL",
"N3535" -> "WAVENEY",
"N3605" -> "ELMBRIDGE",
"N3610" -> "EPSOM AND EWELL",
"N3615" -> "GUILDFORD",
"N3620" -> "MOLE VALLEY",
"N3625" -> "REIGATE AND BANSTEAD",
"N3630" -> "RUNNYMEDE",
"N3635" -> "SPELTHORNE",
"N3640" -> "SURREY HEATH",
"N3645" -> "TANDRIDGE",
"N3650" -> "WAVERLEY",
"N3655" -> "WOKING",
"N3705" -> "NORTH WARWICKSHIRE",
"N3710" -> "NUNEATON AND BEDWORTH",
"N3715" -> "RUGBY",
"N3720" -> "STRATFORD-ON-AVON",
"N3725" -> "WARWICK",
"N3805" -> "ADUR",
"N3810" -> "ARUN",
"N3815" -> "CHICHESTER",
"N3820" -> "CRAWLEY",
"N3825" -> "HORSHAM",
"N3830" -> "MID SUSSEX",
"N3835" -> "WORTHING",
"N3935" -> "SWINDON",
"N3940" -> "WILTSHIRE",
"N4205" -> "BOLTON",
"N4210" -> "BURY",
"N4215" -> "MANCHESTER",
"N4220" -> "OLDHAM",
"N4225" -> "ROCHDALE",
"N4230" -> "SALFORD",
"N4235" -> "STOCKPORT",
"N4240" -> "TAMESIDE",
"N4245" -> "TRAFFORD",
"N4250" -> "WIGAN",
"N4305" -> "KNOWSLEY",
"N4310" -> "LIVERPOOL",
"N4315" -> "ST HELENS",
"N4320" -> "SEFTON",
"N4325" -> "WIRRAL",
"N4405" -> "BARNSLEY",
"N4410" -> "DONCASTER",
"N4415" -> "ROTHERHAM",
"N4420" -> "SHEFFIELD",
"N4505" -> "GATESHEAD",
"N4510" -> "NEWCASTLE CITY",
"N4515" -> "NORTH TYNESIDE",
"N4520" -> "SOUTH TYNESIDE",
"N4525" -> "SUNDERLAND",
"N4605" -> "BIRMINGHAM",
"N4610" -> "COVENTRY",
"N4615" -> "DUDLEY",
"N4620" -> "SANDWELL",
"N4625" -> "SOLIHULL",
"N4630" -> "WALSALL",
"N4635" -> "WOLVERHAMPTON",
"N4705" -> "BRADFORD",
"N4710" -> "CALDERDALE",
"N4715" -> "KIRKLEES",
"N4720" -> "LEEDS",
"N4725" -> "WAKEFIELD",
"N5030" -> "CITY OF LONDON",
"N5060" -> "BARKING AND DAGENHAM",
"N5090" -> "BARNET",
"N5120" -> "BEXLEY",
"N5150" -> "BRENT",
"N5180" -> "BROMLEY",
"N5210" -> "CAMDEN",
"N5240" -> "CROYDON",
"N5270" -> "EALING",
"N5300" -> "ENFIELD",
"N5330" -> "GREENWICH",
"N5360" -> "HACKNEY",
"N5390" -> "HAMMERSMITH AND FULHAM",
"N5420" -> "HARINGEY",
"N5450" -> "HARROW",
"N5480" -> "HAVERING",
"N5510" -> "HILLINGDON",
"N5540" -> "HOUNSLOW",
"N5570" -> "ISLINGTON",
"N5600" -> "KENSINGTON AND CHELSEA",
"N5630" -> "KINGSTON UPON THAMES",
"N5660" -> "LAMBETH",
"N5690" -> "LEWISHAM",
"N5720" -> "MERTON",
"N5750" -> "NEWHAM",
"N5780" -> "REDBRIDGE",
"N5810" -> "RICHMOND UPON THAMES",
"N5840" -> "SOUTHWARK",
"N5870" -> "SUTTON",
"N5900" -> "TOWER HAMLETS",
"N5930" -> "WALTHAM FOREST",
"N5960" -> "WANDSWORTH",
"N5990" -> "CITY OF WESTMINSTER",
"N6805" -> "ISLE OF ANGLESEY",
"N6810" -> "GWYNEDD",
"N6815" -> "CARDIFF",
"N6820" -> "CEREDIGION",
"N6825" -> "CARMARTHENSHIRE",
"N6830" -> "DENBIGHSHIRE",
"N6835" -> "FLINTSHIRE",
"N6840" -> "MONMOUTHSHIRE",
"N6845" -> "PEMBROKESHIRE",
"N6850" -> "POWYS",
"N6855" -> "SWANSEA",
"N6905" -> "CONWY",
"N6910" -> "BLAENAU GWENT",
"N6915" -> "BRIDGEND",
"N6920" -> "CAERPHILLY",
"N6925" -> "MERTHYR TYDFIL",
"N6930" -> "NEATH PORT TALBOT",
"N6935" -> "NEWPORT",
"N6940" -> "RHONDDA CYNON TAF",
"N6945" -> "TORFAEN",
"N6950" -> "THE VALE OF GLAMORGAN",
"N6955" -> "WREXHAM",
"N7655" -> "ORDNANCE SURVEY",
"N7666" -> "ORDNANCE SURVEY",
"N9000" -> "ORKNEY ISLANDS",
"N9010" -> "SHETLAND ISLANDS",
"N9020" -> "NA H-EILEANAN AN IAR",
"N9051" -> "ABERDEEN CITY",
"N9052" -> "ABERDEENSHIRE",
"N9053" -> "ANGUS",
"N9054" -> "ARGYLL AND BUTE",
"N9055" -> "SCOTTISH BORDERS",
"N9056" -> "CLACKMANNANSHIRE",
"N9057" -> "WEST DUNBARTONSHIRE",
"N9058" -> "DUMFRIES AND GALLOWAY",
"N9059" -> "DUNDEE CITY",
"N9060" -> "EAST AYRSHIRE",
"N9061" -> "EAST DUNBARTONSHIRE",
"N9062" -> "EAST LOTHIAN",
"N9063" -> "EAST RENFREWSHIRE",
"N9064" -> "CITY OF EDINBURGH",
"N9065" -> "FALKIRK",
"N9066" -> "FIFE",
"N9067" -> "GLASGOW CITY",
"N9068" -> "HIGHLAND",
"N9069" -> "INVERCLYDE",
"N9070" -> "MIDLOTHIAN",
"N9071" -> "MORAY",
"N9072" -> "NORTH AYRSHIRE",
"N9073" -> "NORTH LANARKSHIRE",
"N9074" -> "PERTH AND KINROSS",
"N9075" -> "RENFREWSHIRE",
"N9076" -> "SOUTH AYRSHIRE",
"N9077" -> "SOUTH LANARKSHIRE",
"N9078" -> "STIRLING",
"N9079" -> "WEST LOTHIAN",
"N9999" -> "GEOPLACE")
}