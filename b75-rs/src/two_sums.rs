use std::collections::HashMap;

struct TwoSums;

impl TwoSums {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {

        let mut prev = HashMap::new();

        for (index, num) in nums.into_iter().enumerate() {
            let other = target - num;
            if let Some(other_index) = prev.get(&other) {
                return vec![*other_index as i32, index as i32];
            } else {
                prev.insert(num, index);
            }
        }

        vec![]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test1() {
        assert_eq!(vec![0, 1], TwoSums::two_sum(vec![2,7,11,15], 9));
    }

    #[test]
    fn test2() {
        assert_eq!(vec![0, 1], TwoSums::two_sum(vec![3, 3], 6));
    }

    #[test]
    fn test3() {
        assert_eq!(vec![1, 2], TwoSums::two_sum(vec![3,2,4], 6));
    }
}