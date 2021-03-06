def strArray = new String[3]
assert strArray instanceof String[]
strArray[0] = 'mrhaki'
strArray.putAt(1, 'Groovy')  // New syntax.
strArray[2] = 'Java'

assert 'mrhaki' == strArray.getAt(0)  // Just another way to get a value.
assert 'Groovy' == strArray[1]
assert 'Java' == strArray[-1]  // Negative indeces allowed.
assert ['mrhaki', 'Groovy'] == strArray[0..1]  // We can use ranges.
assert ['mrhaki', 'Java'] == strArray[0, 2]

assert 3 == strArray.length  // Normal length property for arrays.
assert 3 == strArray.size()  // Groovy adds size() method as well.

// We can use min() and max() methods.
assert 42 == [102,301,42,83].min()
assert 301 == [102,301,42,83].max()
assert 'Java' == strArray.min { it.size() }
assert 'mrhaki' == strArray.max { it[0] as char }

// We can even use the Collection GDK methods on an array.
strArray.eachWithIndex { value, idx -> assert value == strArray[idx] }
assert ['ikahrm', 'yvoorG', 'avaJ'] == strArray.collect { it.reverse() }
assert 'Groovy' == strArray.find { it =~ /Groovy/ }

// We can remove values with the '-' operator.
assert ['Groovy', 'Java'] == strArray - 'mrhaki'

// Other useful methods for arrays.
assert ['Java', 'Groovy', 'mrhaki'] == strArray.reverse()
assert ['Groovy', 'Java', 'mrhaki'] == strArray.sort()
assert 1 == strArray.count('mrhaki')

// Convert to ArrayList.
def strList = strArray.toList()
assert 'java.util.ArrayList' == strList.class.name

// Convert ArrayList to array object.
def otherArray = strList as String[]
assert otherArray instanceof String[]
