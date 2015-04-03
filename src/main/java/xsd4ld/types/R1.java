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

package xsd4ld.types;

/** The singleton registry */ 
public class R1 {
    static public XSD_Simple             xsdSimple             = new XSD_Simple() ;
    static public XSD_Atomic             xsdAtomic             = new XSD_Atomic() ;

    static public XSD_Decimal            xsdDecimal            = new XSD_Decimal() ;
    static public XSD_Integer            xsdInteger            = new XSD_Integer() ;

    static public XSD_Long               xsdLong               = new XSD_Long() ;
    static public XSD_Int                xsdInt                = new XSD_Int() ;
    static public XSD_Short              xsdShort              = new XSD_Short() ;
    static public XSD_Byte               xsdByte               = new XSD_Byte() ;

    static public XSD_NegativeInteger    xsdNegativeInteger    = new XSD_NegativeInteger() ;
    static public XSD_NonNegativeInteger xsdNonNegativeInteger = new XSD_NonNegativeInteger() ;
    static public XSD_NonPositiveInteger xsdNonPositiveInteger = new XSD_NonPositiveInteger() ;
    static public XSD_PositiveInteger    xsdPositiveInteger    = new XSD_PositiveInteger() ;

    static public XSD_UnsignedLong       xsdUnsignedLong       = new XSD_UnsignedLong() ;
    static public XSD_UnsignedInt        xsdUnsignedInt        = new XSD_UnsignedInt() ;
    static public XSD_UnsignedShort      xsdUnsignedShort      = new XSD_UnsignedShort() ;
    static public XSD_UnsignedByte       xsdUnsignedByte       = new XSD_UnsignedByte() ;

    static public XSD_DateTimeStamp      xsdDateTimeStamp      = new XSD_DateTimeStamp() ;
    static public XSD_DateTime           xsdDateTime           = new XSD_DateTime() ;
    static public XSD_Date               xsdDate               = new XSD_Date() ;
    static public XSD_Time               xsdTime               = new XSD_Time() ;

    static public XSD_GYear              xsdGYear              = new XSD_GYear() ;
    static public XSD_GYearMonth         xsdGYearMonth         = new XSD_GYearMonth() ;
    static public XSD_GMonthDay          xsdGMonthDay          = new XSD_GMonthDay() ;
    static public XSD_GDay               xsdGDay               = new XSD_GDay() ;
    static public XSD_GMonth             xsdGMonth             = new XSD_GMonth() ;
}

