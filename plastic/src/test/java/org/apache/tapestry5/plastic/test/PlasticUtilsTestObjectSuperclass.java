// Copyright 2023 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.plastic.test;

public class PlasticUtilsTestObjectSuperclass 
{
    
    public static final String SUPER = "Super!!!";
    
    private String superString = SUPER;
    
    private String overridden = "from superclass";

    public String getSuperString() 
    {
        return superString;
    }

    public void setSuperString(String superString) 
    {
        this.superString = superString;
    }
    
}
