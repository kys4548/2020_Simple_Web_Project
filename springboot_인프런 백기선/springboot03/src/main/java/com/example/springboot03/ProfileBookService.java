package com.example.springboot03;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service @Profile("test")
public class ProfileBookService {
}
