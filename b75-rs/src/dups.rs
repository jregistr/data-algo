use std::collections::HashSet;

struct ContainsDuplicates;
impl ContainsDuplicates {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        let mut hash = HashSet::new();
        !nums.into_iter().all(|num| hash.insert(num))
    }
}