// Copyright 2010 The Apache Software Foundation
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

package org.apache.tapestry5.ioc;

import java.util.Map;

import org.slf4j.Logger;

public class InjectionCheckImpl implements InjectionCheck
{

    private final Logger logger;

    private final Map<String, Object> configuration;

    public InjectionCheckImpl(Logger logger, Map<String, Object> configuration)
    {
        this.logger = logger;
        this.configuration = configuration;
    }

    public Logger getLogger()
    {
        return logger;
    }

    public Object getValue(String key)
    {
        return configuration.get(key);
    }

}
