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
package org.apache.tapestry5.ioc.services;

public interface Java9Service 
{
    
    void tryWithResources();
    
    void callSafeVarArgs();

    default void defaultMethod()
    {
        privateMethodInInterface();
    }
    
    /**
     * For testing Support for Private Interface Methods
     * https://docs.oracle.com/en/java/javase/17/language/java-language-changes.html#GUID-015392DB-F5C4-4A8E-B190-E797707E7BFB
     */
    private void privateMethodInInterface()
    {
    }
}