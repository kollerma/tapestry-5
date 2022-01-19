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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java15To17ConcreteService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Java15To17ConcreteService.class);
    
    public Java15To17ConcreteService() 
    {
        recordsWithoutInterfacesNorRecords();
    }

    /**
     * Tests Record Classes, regular ones (no interfaces, no records).
     * https://docs.oracle.com/en/java/javase/17/language/records.html
     */
    public void recordsWithoutInterfacesNorRecords() 
    {
        Appliance appliance = new WashingMachine();
        CoolingMachine coolingMachine = new Freezer();
        coolingMachine = new Refrigerator();
        LOGGER.info("Appliance: " + appliance.getName());
        LOGGER.info("Cooling machine: " + coolingMachine.getName());
    }
    
    /**
     * Tests Record Classes with interfaces but no records.
     * https://docs.oracle.com/en/java/javase/17/language/records.html
     */
    public void recordsWithInterfacesButNotRecords() 
    {
        BinaryExpression expression = new AndExpression(
                new OrExpression(new ConstantBinaryExpression(false), new ConstantBinaryExpression(true)),
                new AndExpression(new ConstantBinaryExpression(false), new ConstantBinaryExpression(true))
        );
        LOGGER.info("Binary expression: " + expression.evaluate());
    }

    /**
     * Tests Record Classes with interfaces and records.
     * https://docs.oracle.com/en/java/javase/17/language/records.html
     */
    public void recordsWithInterfacesAndRecords() 
    {
        IntExpression expression = new SquareExpression(
                new PlusExpression(new ConstantIntExpression(2), new ConstantIntExpression(3)));
        LOGGER.info("Int expression: " + expression.evaluate());
    }

}