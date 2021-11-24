/**
 * api.jsonDecode can only decode json objects, but not string, numbers, arrays, or null values. For example, the following can be decoded:<br>
 * <code>{"prop1": 1, "prop2: "val"}</code><br>
 * but the array<br>
 * <code>[{"prop":1},{"prop":2} ]</code><br>
 * can not be decoded directly by api.jsonDecode().<br>
 * <br>
 * This method allows decoding of arrays as well.
 * @param json the decoded json as a map.
 */
def jsonDecode(String json) {
    return api.jsonDecode("{\"dummy\": $json}").dummy
}