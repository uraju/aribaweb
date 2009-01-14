/*
    Copyright 1996-2008 Ariba, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/widgets/ariba/ui/widgets/SearchBox.java#3 $
*/

package ariba.ui.widgets;

import ariba.ui.aribaweb.core.AWComponent;

public class SearchBox extends AWComponent
{
    public boolean showToggle ()
    {
        return hasBinding("toggleState");            
    }

    public boolean showBodyTopArea ()
    {
        return  hasSubTemplateNamed("bodyTopArea") && !booleanValueForBinding("hideBodyTopArea");
    }

    public boolean showBodyArea ()
    {
        return !booleanValueForBinding("hideBodyArea");
    }

    public boolean showFooterArea ()
    {
        boolean hasTemplate = hasSubTemplateNamed("footerLeftArea") || hasSubTemplateNamed("footerRightArea");
        return hasTemplate && !booleanValueForBinding("hideFooterArea");
    }
}
