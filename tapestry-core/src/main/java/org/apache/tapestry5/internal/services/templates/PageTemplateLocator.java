// Copyright 2010, 2011 The Apache Software Foundation
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

package org.apache.tapestry5.internal.services.templates;

import java.util.Locale;

import org.apache.tapestry5.TapestryConstants;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.internal.util.InternalUtils;
import org.apache.tapestry5.model.ComponentModel;
import org.apache.tapestry5.services.ComponentClassResolver;
import org.apache.tapestry5.services.templates.ComponentTemplateLocator;

/**
 * The special case for pages, where the template is searched for in the web application context.
 * 
 * @since 5.2.0
 */
public class PageTemplateLocator implements ComponentTemplateLocator
{
    private final Resource contextRoot;

    private final ComponentClassResolver resolver;

    public PageTemplateLocator(Resource contextRoot, ComponentClassResolver resolver)
    {
        this.contextRoot = contextRoot;
        this.resolver = resolver;
    }

    public Resource locateTemplate(ComponentModel model, Locale locale)
    {
        if (!model.isPage()) { return null; }

        String className = model.getComponentClassName();

        String logicalName = resolver.resolvePageClassNameToPageName(className);

        int slashx = logicalName.lastIndexOf('/');

        if (slashx > 0)
        {
            // However, the logical name isn't quite what we want. It may have been somewhat
            // trimmed.

            String simpleClassName = InternalUtils.lastTerm(className);

            logicalName = logicalName.substring(0, slashx + 1) + simpleClassName;
        }

        String path = String.format("%s.%s", logicalName, TapestryConstants.TEMPLATE_EXTENSION);

        return contextRoot.forFile(path).forLocale(locale);
    }

}
