use std::collections::HashSet;

struct ContainsDuplicates;
impl ContainsDuplicates {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        let mut hash = HashSet::new();
        !nums.into_iter().all(|num| hash.insert(num))
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test1() {
        assert_eq!(true, ContainsDuplicates::contains_duplicate(vec![1,2,3,1]))
    }

    #[test]
    fn test2() {
        assert_eq!(false, ContainsDuplicates::contains_duplicate(vec![1,2,3,4]))
    }
}