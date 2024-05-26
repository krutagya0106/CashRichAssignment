package com.cashrich.NewRestfulApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.NewRestfulApi.models.ApiRequestResponseBean;

public interface ApiRepository extends JpaRepository<ApiRequestResponseBean, Long> {

}
