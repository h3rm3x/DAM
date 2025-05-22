--- FUNCTION                    --- SYNTAX                                                                          -USE CASE
JSON_SET                        JSON_SET(extras_json, "$spa", JSON_OBJECT("total", 0, "ticket", JSON_ARRAY()))       -- Set a value in a JSON document

JSON_EXISTS                     JSON_EXISTS(JSON, path)                 --  Check if a path exists in a JSON document

JSON_OBJECT                     JSON_OBJECT(key, value[, ...])             -- Create a JSON object   

JSON_INSERT                     JSON_INSERT(JSON, path, value[, ...])       -- Insert a value in a JSON document

JSON_REPLACE                    JSON_REPLACE(JSON, path, value[, ...])       -- Replace a value in a JSON document

JSON_EXTRACT

JSON_KEYS

JSON_VALUE

JSON_LENGTH

JSON_QUERY

JSON_CONTAINS

JSON_PRETTY

JSON_LOOSE

JSON_ARRAY

JSON_ARRAYA_INSERT

JSON_ARRAY_APPEND               JSON_ARRAY_APPEND(JSON, path, value[, ...])       