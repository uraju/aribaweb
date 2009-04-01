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

    $Id: //ariba/platform/ui/aribaweb/ariba/ui/aribaweb/test/TestUnit.java#5 $
*/

package ariba.ui.aribaweb.test;

import ariba.util.core.ClassUtil;
import ariba.util.core.ListUtil;
import ariba.util.core.StringUtil;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class TestUnit
{
    private String _name;
    private String _mainName;
    private String _secondName;
    
    private List<TestLinkHolder> _uiWithParamLinks = ListUtil.list();
    private List<TestLinkHolder> _uiNoParamLinks = ListUtil.list();
    private List<TestLinkHolder> _noUIWithParamLinks = ListUtil.list();
    private List<TestLinkHolder> _noUiNoParamLinks = ListUtil.list();

    private List<TestLinkHolder> _stagers = ListUtil.list();
    private List<TestLinkHolder> _pageAccessLinks = ListUtil.list();

    private boolean _displayTestContextValue = false;

    public TestUnit(String name, List<TestLinkHolder> links)
    {
        _name = name;
        _mainName = ClassUtil.stripPackageFromClassName(name);
        _secondName = ClassUtil.stripClassFromClassName(name);

        for (TestLinkHolder link : links) {
            if (link.isInteractive()) {
                if (link.requiresParam()) {
                    _uiWithParamLinks.add(link);
                }
                else {
                    _uiNoParamLinks.add(link);
                }
                _pageAccessLinks.add(link);
            }
            else {
                if (link.requiresParam()) {
                    _noUIWithParamLinks.add(link);
                }
                else {
                    _noUiNoParamLinks.add(link);
                }
                _stagers.add(link);
            }
        }
        if (links.size() > 0) {
            String type = links.get(0).getType();
            if (type != null && type.equals(_name)) {
                _displayTestContextValue = true;
            }
        }
    }

    public boolean displayTestContextValue ()
    {
        return _displayTestContextValue;    
    }

    public String getFullName ()
    {
        return _name;
    }
    public String getMainName ()
    {
        return _mainName;
    }
    public String getSecondaryName ()
    {
        return _secondName;
    }

    public List uiParamLinks ()
    {
        return _uiWithParamLinks;
    }

    public List uiNoParamLinks ()
    {
        return _uiNoParamLinks;
    }

    public List noUiParamLinks ()
    {
        return _noUIWithParamLinks;
    }

    public List noUiNoParamLinks ()
    {
        return _noUiNoParamLinks;
    }

    public List stagers ()
    {
        return _stagers;
    }

    public List pageAccessLinks ()
    {
        return _pageAccessLinks;
    }
    

    public boolean hasUiParamLinks ()
    {
        return _uiWithParamLinks.size() > 0;
    }

    public boolean hasUiNoParamLinks ()
    {
        return _uiNoParamLinks.size() > 0;
    }

    public boolean hasNoUiParamLinks ()
    {
        return _noUIWithParamLinks.size() > 0;
    }

    public boolean hasNoUiNoParamLinks ()
    {
        return _noUiNoParamLinks.size() > 0;
    }

    public boolean hasStagers ()
    {
        return _stagers.size() > 0;
    }

    public boolean hasPageAccessLinks ()
    {
        return _pageAccessLinks.size() > 0;
    }

    public void sort ()
    {
        sort(_uiWithParamLinks);
        sort(_uiNoParamLinks);
        sort(_noUIWithParamLinks);
        sort(_noUiNoParamLinks);
        sort(_pageAccessLinks);
        sort(_stagers);

    }
    
    private void sort (List<TestLinkHolder> list)
    {
        Collections.sort(list,
                 new Comparator() {
                     public int compare (Object object1, Object object2)
                     {
                         TestLinkHolder c1 = (TestLinkHolder)object1;
                         TestLinkHolder c2 = (TestLinkHolder)object2;
                         return c1.getDisplayName().toLowerCase().compareTo(
                                 c2.getDisplayName().toLowerCase());
                     }
                     public boolean equals (Object o1, Object o2)
                     {
                         return compare(o1, o2) == 0;
                     }
                 });
    }
}
