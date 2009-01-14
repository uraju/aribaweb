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

    $Id: //ariba/platform/ui/widgets/ariba/ui/table/AWTRowAttributeLabelColumnRenderer.java#5 $
*/
package ariba.ui.table;

public final class AWTRowAttributeLabelColumnRenderer extends AWTDataTable.ColumnRenderer
{
    public String label ()
    {
        AWTDataTable.Column column = _table._pivotState._rowOverrideColumn;
        column.prepare(_table);
        return column.label(_table);
    }

    public String indentationStyle ()
    {
        return _table.emitColumnStyle(null);
    }
}