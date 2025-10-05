## FILTER FEATURES
### Description 
Features need to be implemented with filter functionality, with different features we have different filter.

### version 
1.0

## Features
* **Computer :** chipsetMotherboard (entity), active(boolean), model(string), marque(entity), working(boolean), type(string)
  * chipsetMotherboard: popular chipset motherboard
  * active: active or not
  * model: model of the computer
  * marque: marque of the computer
  * working: working or not
  * type: server, pc, desktop, workstation

* **Cpu**: generation, name, marque, frequency
  * generation: popular generation
  * name: popular cpu names
  * marque: popular cpu marques
  * frequency: cpu frequency

* **Hard drive**: size, type, interface, model, marque
  * size: size of the hard drive
  * type: type of the hard drive
  * model: model of the hard drive
  * marque: marque of the hard drive

* **memory**: 
  * size: popular size of memory
  * type: popular type of memory
  * frequency: popular frequency of memory
  * marque: popular marque of memory

## Filter Process
Initial count attributes for each model (Initial count feature attributes)

`
    times = Request contains (bodyFilterResource) -> Response contains (Body response + new count attributes) 
`

* **Count attributes model**
```json
{
  "model": "Name of Model",
  "model_code": "model_code",
  "model_display_name": "model_display_name",
  "count_attributes": [
    {
      "display_name": "attribute name",
      "attribute_name": "attribute dedicated name",
      "attribute_code": "attribute_code",
      "possible_values": [
        {
          "value": "x_1",
          "value_display_name": "value_display_name",
          "value_code": "value_code",
          "count": 0,
          "is_applied": false,
          "value_sort_order": number
        },
        {
          "value": "x_2",
          "value_display_name": "value_display_name",
          "value_code": "value_code",
          "count": 0,
          "is_applied": false,
          "value_sort_order": number
        },
        {
          "value": "x_3",
          "value_display_name": "x_3_display_name",
          "value_code": "x_3_code",
          "count": 0,
          "is_applied": false,
          "value_sort_order": number
        }
      ],
      "range_support": true,
      "is_multiselect": boolean,
      "attribute_type": "enum" | boolean (binary),
      "is_searchable": boolean,
      "is_shown": boolean,
      "show_priority": 1,
      "version": 1
    }
  ]
}

```
**Example**
```json
{
  "model": "Computer",
  "model_code": "computer",
  "model_display_name": "Computer",
  "count_attributes": [
    {
      "display_name": "Type",
      "attribute_name": "type",
      "attribute_code": "computer_type",
      "possible_values": [
        {
          "value": "server",
          "value_display_name": "Server",
          "value_code": "srv",
          "count": 12,
          "is_applied": false,
          "value_sort_order": 1
        },
        {
          "value": "pc",
          "value_display_name": "PC",
          "value_code": "pc",
          "count": 45,
          "is_applied": false,
          "value_sort_order": 2
        },
        {
          "value": "desktop",
          "value_display_name": "Desktop",
          "value_code": "dt",
          "count": 33,
          "is_applied": false,
          "value_sort_order": 3
        }
      ],
      "range_support": false,
      "is_multiselect": false,
      "is_searchable": false,
      "attribute_type": "enum",
      "is_shown": true,
      "show_priority": 1,
      "version": 1
    },
    {
      "display_name": "Active",
      "attribute_name": "active",
      "attribute_code": "active_status",
      "possible_values": [
        {
          "value": "true",
          "value_display_name": "Active",
          "value_code": "act_true",
          "count": 27,
          "is_applied": false,
          "value_sort_order": 1
        },
        {
          "value": "false",
          "value_display_name": "Inactive",
          "value_code": "act_false",
          "count": 18,
          "is_applied": false,
          "value_sort_order": 2
        }
      ],
      "range_support": false,
      "is_multiselect": false,
      "is_searchable": false,
      "attribute_type": "boolean",
      "is_shown": true,
      "show_priority": 2,
      "version": 1
    },
    {
      "display_name": "Chipset Motherboard",
      "attribute_name": "chipsetMotherboard",
      "attribute_code": "chipset_mb",
      "possible_values": [
        {
          "value": "intel_z790",
          "value_display_name": "Intel Z790",
          "value_code": "z790",
          "count": 8,
          "is_applied": false,
          "value_sort_order": 1
        },
        {
          "value": "amd_b550",
          "value_display_name": "AMD B550",
          "value_code": "b550",
          "count": 5,
          "is_applied": false,
          "value_sort_order": 2
        }
      ],
      "range_support": false,
      "is_multiselect": true,
      "is_searchable": true,
      "attribute_type": "enum",
      "is_shown": true,
      "show_priority": 3,
      "version": 1
    },
    {
      "display_name": "Working",
      "attribute_name": "working",
      "attribute_code": "working_status",
      "possible_values": [
        {
          "value": "true",
          "value_display_name": "Working",
          "value_code": "wrk_true",
          "count": 40,
          "is_applied": false,
          "value_sort_order": 1
        },
        {
          "value": "false",
          "value_display_name": "Not Working",
          "value_code": "wrk_false",
          "count": 7,
          "is_applied": false,
          "value_sort_order": 2
        }
      ],
      "range_support": false,
      "is_multiselect": false,
      "is_searchable": false,
      "attribute_type": "boolean",
      "is_shown": true,
      "show_priority": 4,
      "version": 1
    }
  ]
}
```

* **Apply filter Request Model**
```json
    {
  "model": "Name of Model",
  "model_code": "model_code",
  "count_attributes": [
    {
      "attribute_name": "attribute dedicated name",
      "attribute_code": "attribute_code",
      "applied_values": [
        {
          "value": "x_1",
          "value_code": "value_code"
        }
      ]
    }
  ]
}
```
** Example **
```json
    {
  "model": "Computer",
  "model_code": "computer",
  "count_attributes": [
    {
      "attribute_name": "type",
      "attribute_code": "computer_type",
      "applied_values": [
        {
          "value": "server",
          "value_code": "srv"
        },
        {
          "value": "pc",
          "value_code": "pc"
        }
      ]
    },
    {
      "attribute_name": "active",
      "attribute_code": "active_status",
      "applied_values": [
        {
          "value": "true",
          "value_code": "act_true"
        }
      ]
    }
  ]
}
```
