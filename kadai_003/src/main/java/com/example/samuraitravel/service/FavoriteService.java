package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Favorite;
import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.repository.FavoriteRepository;

import jakarta.transaction.Transactional;

@Service

public class FavoriteService {
	private final FavoriteRepository favoriteRepository;
	
	public FavoriteService(FavoriteRepository favoriteRepository) {
		 this.favoriteRepository = favoriteRepository; 
	}
	@Transactional
	public void create(House house,User user) {
		Favorite favorite = new Favorite();
		favorite.setHouse(house);
		favorite.setUser(user);
		
		favoriteRepository.save(favorite);
	}
	
	public boolean isFavorite(House house,User user) {
		return favoriteRepository.findByHouseAndUser(house, user) != null;
	}
	

}
