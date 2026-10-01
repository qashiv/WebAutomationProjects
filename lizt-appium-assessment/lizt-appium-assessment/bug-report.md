# Bug Reports

## BUG-001 – Item edit functionality is unavailable

**Severity:** Medium  
**Priority:** Medium  
**Area:** List details / Items  
**Status:** Open

### Preconditions
1. Launch Lizt.
2. Create a list.
3. Create a category.
4. Add an item.

### Steps to reproduce
1. Open the list details screen.
2. Expand the category containing the item.
3. Try to edit the existing item.

### Expected
An edit action should be available so the item name/details can be changed without deleting and recreating the item.

### Actual
The current UI exposes completion/uncompletion and deletion for an item, but no edit action.

### Automation impact
TC20 is intentionally skipped and documented rather than falsely claiming coverage.

### Recommendation
Add an item edit action/modal similar to the existing category edit flow.
