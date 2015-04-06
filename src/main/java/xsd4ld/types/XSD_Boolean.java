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

import xsd4ld.XSDConst ;
import xsd4ld.XSDTypeRegistry ;

public class XSD_Boolean extends BaseBoolean {
    public XSD_Boolean() {
        super(XSDConst.xsd_boolean, XSDConst.xsd_atomic, XSDTypeRegistry.getRegex(XSDConst.xsd_boolean)) ;
    }
}

