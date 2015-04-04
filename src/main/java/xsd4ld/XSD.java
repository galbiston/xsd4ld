/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xsd4ld ;

import generate.* ;
import xsd4ld.types.* ;

public class XSD {
    static public XSDDatatype xsdSimple             = new XSD_Simple() ;
    static public XSDDatatype xsdAtomic             = new XSD_Atomic() ;

    static public XSDDatatype xsdDecimal            = new XSD_Decimal() ;
    static public XSDDatatype xsdInteger            = new XSD_Integer() ;

    static public XSDDatatype xsdDouble             = new XSD_Double() ;
    static public XSDDatatype xsdFloat              = new XSD_Float() ;

    static public XSDDatatype xsdLong               = new XSD_Long() ;
    static public XSDDatatype xsdInt                = new XSD_Int() ;
    static public XSDDatatype xsdShort              = new XSD_Short() ;
    static public XSDDatatype xsdByte               = new XSD_Byte() ;

    static public XSDDatatype xsdNegativeInteger    = new XSD_NegativeInteger() ;
    static public XSDDatatype xsdNonNegativeInteger = new XSD_NonNegativeInteger() ;
    static public XSDDatatype xsdNonPositiveInteger = new XSD_NonPositiveInteger() ;
    static public XSDDatatype xsdPositiveInteger    = new XSD_PositiveInteger() ;

    static public XSDDatatype xsdUnsignedLong       = new XSD_UnsignedLong() ;
    static public XSDDatatype xsdUnsignedInt        = new XSD_UnsignedInt() ;
    static public XSDDatatype xsdUnsignedShort      = new XSD_UnsignedShort() ;
    static public XSDDatatype xsdUnsignedByte       = new XSD_UnsignedByte() ;

    static public XSDDatatype xsdDuration           = new XSD_Duration() ;
    static public XSDDatatype xsdYearMonthDuration  = new XSD_YearMonthDuration() ;

    static public XSDDatatype xsdString             = new XSD_String() ;
    static public XSDDatatype xsdNormalizedString   = new XSD_NormalizedString(null, null) ;
    static public XSDDatatype xsdLanguage           = new XSD_Language() ;

    static public XSDDatatype xsdDateTimeStamp      = new XSD_DateTimeStamp() ;
    static public XSDDatatype xsdDateTime           = new XSD_DateTime() ;
    static public XSDDatatype xsdDate               = new XSD_Date() ;
    static public XSDDatatype xsdTime               = new XSD_Time() ;

    static public XSDDatatype xsdGYear              = new XSD_GYear() ;
    static public XSDDatatype xsdGYearMonth         = new XSD_GYearMonth() ;
    static public XSDDatatype xsdGMonthDay          = new XSD_GMonthDay() ;
    static public XSDDatatype xsdGDay               = new XSD_GDay() ;
    static public XSDDatatype xsdGMonth             = new XSD_GMonth() ;
}
