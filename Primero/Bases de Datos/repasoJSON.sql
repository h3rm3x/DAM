--- FUNCTION                    --- SYNTAX                                                                          -USE CASE
JSON_SET                        JSON_SET(extras_json, "$spa", JSON_OBJECT("total", 0, "ticket", JSON_ARRAY()))       -- Set a value in a JSON document

JSON_EXISTS                     JSON_EXISTS(JSON, path)                                                              --  Check if a path exists in a JSON document

JSON_OBJECT                     JSON_OBJECT(key, value[, ...])                                                       -- Create a JSON object   

JSON_INSERT                     JSON_INSERT(JSON, path, value[, ...])                                                -- Insert a value in a JSON document

JSON_REPLACE                    JSON_REPLACE(JSON, path, value[, ...])                                               -- Replace a value in a JSON document

JSON_EXTRACT                    JSON_EXTRACT(JSON, path[, ...])                                                      -- Extract a value from a JSON document  

JSON_KEYS                       JSON_KEYS(JSON, path)                                                                -- Get the keys of a JSON object

JSON_VALUE                      JSON_VALUE(JSON, path)                                                               -- Get a scalar value from a JSON document

JSON_LENGTH                     JSON_LENGTH(JSON, path)                                                              -- Get the length of a JSON array or object 

JSON_QUERY                      JSON_QUERY(JSON, path)                                                               -- Get a JSON value from a JSON document

JSON_CONTAINS                   JSON_CONTAINS(JSON, candidate[, path])                                               -- Check if a JSON document contains a value

JSON_PRETTY                     JSON_PRETTY(JSON)                                                                    -- Format a JSON document for readability

JSON_LOOSE                      JSON_LOOSE(JSON)                                                                     -- Format a JSON document for readability

JSON_ARRAY                      JSON_ARRAY(value[, ...])                                                             -- Create a JSON array

JSON_ARRAY_INSERT               JSON_ARRAY_INSERT(JSON, path, value[, ...])                                          -- Insert a value into a JSON array

JSON_ARRAY_APPEND               JSON_ARRAY_APPEND(JSON, path, value[, ...])                                          -- Append a value to a JSON array