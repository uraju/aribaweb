/*
    Copyright 2008 Craig Federighi

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/metaui/ariba/ui/meta/persistence/DetailDataSource.java#1 $
*/
package ariba.ui.meta.persistence;

import ariba.ui.table.AWTDataSource;
import ariba.ui.table.AWTEntity;
import ariba.ui.meta.core.UIMeta;
import ariba.ui.meta.core.Context;
import ariba.util.fieldvalue.FieldPath;

import java.util.List;
import java.util.ArrayList;

public class DetailDataSource extends AWTDataSource
{
    Object _parentObject;
    FieldPath _detailFieldPath;

    public DetailDataSource (Object parent, String keyPath)
    {
        _parentObject = parent;
        _detailFieldPath = new FieldPath(keyPath);
    }

    public List fetchObjects()
    {
        return (List)_detailFieldPath.getFieldValue(_parentObject);
    }

    public AWTEntity entity()
    {
        // Todo?
        return null;
    }

    String detailClassName ()
    {
        UIMeta meta = UIMeta.getInstance();
        Context context = meta.newContext();
        context.set(UIMeta.KeyClass, _parentObject.getClass().getName());
        context.set(UIMeta.KeyField, _detailFieldPath.fieldPathString());
        return (String)context.propertyForKey(UIMeta.KeyElementType);
    }

    List listForUpdate ()
    {
        // make sure we're updating the right instance...
        Object parent = _parentObject; // ObjectContext.get().merge(_parentObject);
        List list = (List)_detailFieldPath.getFieldValue(parent);
        if (list == null) {
            list = new ArrayList();
            _detailFieldPath.setFieldValue(parent, list);
        }
        return list;
    }

    public Object insert()
    {
        Object instance = ObjectContext.get().create(detailClassName());
        listForUpdate().add(instance);
        return instance;
    }

    public void delete(Object object)
    {
        listForUpdate().remove(object);
    }
}