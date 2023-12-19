package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final HouseRepository houseRepository;  
    private final UserRepository userRepository;

    
    public ReviewService(ReviewRepository reviewRepository,HouseRepository houseRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.houseRepository = houseRepository;  
        this.userRepository = userRepository;
    }


	@Transactional
	public void create(House house,User user,ReviewForm reviewForm) {
		Review review = new Review();
		review.setHouse(house);
		review.setUser(user);
		review.setEvaluation(reviewForm.getEvaluation());
		review.setComments(reviewForm.getComments());
		reviewRepository.save(review);
	}

	@Transactional
	public void update(ReviewEditForm reviewEditForm) {
		Review review = reviewRepository.getReferenceById(reviewEditForm.getId());
		review.setEvaluation(reviewEditForm.getEvaluation());
		review.setComments(reviewEditForm.getComments());
		reviewRepository.save(review);
	}
	public boolean hasUserAlreadyReviewed(House house, User user) {
        return reviewRepository.findByHouseAndUser(house, user) != null;
    }

}
