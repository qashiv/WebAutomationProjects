# Lizt Mobile Automation – Test Cases

| ID | Test case | Type | Expected result |
|---|---|---|---|
| TC01 | App launch | Positive | Home screen loads successfully |
| TC02 | Empty-state UI | UI/Edge | Fresh/empty state renders correctly |
| TC03 | Create list | Positive | New list is created and opened |
| TC04 | Create list without title | Negative | Validation message is shown |
| TC05 | Edit list | Positive | List title is updated |
| TC06 | Delete list | Positive | List is removed after confirmation |
| TC07 | Cancel list deletion | Negative/UI | List remains after cancel |
| TC08 | Create category | Positive | Category is displayed |
| TC09 | Add item | Positive | Item is displayed in category |
| TC10 | Add empty item | Negative | Validation message is shown |
| TC11 | Complete item | Positive | Item becomes completed and Delete is available |
| TC12 | Uncomplete item | Positive | Completed state is removed |
| TC13 | Delete completed item | Positive | Item is removed |
| TC14 | Back navigation | Navigation | Details → Home works |
| TC15 | Reminders navigation | Navigation | Reminders screen opens |
| TC16 | Settings navigation | Navigation | Settings screen opens |
| TC17 | Data persistence | Persistence | List remains after terminate/activate |
| TC18 | Long list title | UI/Edge | Long title can be saved/displayed |
| TC19 | Multiple items | Edge | Multiple items coexist in one category |
| TC20 | Edit item | Gap/Bug | **SKIPPED** because current product has no item edit action; see BUG-001 |

## Coverage mapping

- Positive: TC01, TC03, TC05, TC08, TC09, TC11, TC12, TC13
- Negative: TC04, TC07, TC10
- UI/edge: TC02, TC07, TC18, TC19
- Persistence: TC17
- Navigation: TC14, TC15, TC16
- Required list flow: TC03, TC05, TC06
- Required item flow: TC09, TC13, TC11, TC12; edit is blocked by product gap
