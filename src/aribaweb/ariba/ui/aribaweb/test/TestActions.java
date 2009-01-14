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

    $Id: //ariba/platform/ui/aribaweb/ariba/ui/aribaweb/test/TestActions.java#2 $
*/

package ariba.ui.aribaweb.test;

import ariba.ui.aribaweb.core.AWDirectAction;
import ariba.ui.aribaweb.core.AWRequestContext;
import ariba.ui.aribaweb.core.AWResponseGenerating;

public class TestActions extends AWDirectAction
{
    public final static String CentralPage = "centralPage";

    public AWResponseGenerating centralPageAction ()
    {
        return requestContext().pageWithName(AWTestCentralPage.Name);
    }

    protected boolean shouldValidateSession ()
    {
        return false;
    }

    protected void validateRequest (AWRequestContext requestContext)
    {
    }
}