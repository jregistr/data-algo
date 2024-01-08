use std::collections::HashMap;

struct GroupAnagrams;

fn sorted_chars(value: &str) -> String {
    let mut characters: Vec<char> = value.chars().collect();
    characters.sort();
    characters.into_iter().collect()
}

impl GroupAnagrams {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut groups = HashMap::<String, Vec<String>>::new();

        for value in strs {
            let sorted = sorted_chars(&value);
            groups.entry(sorted).or_insert(vec![]).push(value)
        }

        groups.into_values().collect()
    }
}