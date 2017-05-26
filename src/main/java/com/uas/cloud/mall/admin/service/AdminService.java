package com.uas.cloud.mall.admin.service;

import org.springframework.stereotype.Service;

/**
 * 后台管理服务
 *
 * @author yangck
 * @create 2017-02-16 16:45
 */
@Deprecated
@Service
public class AdminService {

    //private final Logger logger = LogManager.getLogger(getClass());
    //
    //@Autowired
    //private RestTemplate restTemplate;
    //
    //@HystrixCommand(fallbackMethod = "saveCategoryFallback")
    //public Category saveCategory(Category category) {
    //    ResponseEntity<Category> responseEntity = restTemplate.postForEntity("http://MALL-CATEGORY-SERVICE/category", Category.class, null);
    //    return responseEntity.getBody();
    //}
    //
    //public Category saveCategoryFallback(Category category) {
    //    logger.error("MALL-CATEGORY-SERVICE unavailable");
    //    return new Category();
    //}
    //
    //@HystrixCommand(fallbackMethod = "getCategoryFallback")
    //public Category getCategory(Long id) {
    //    return restTemplate.getForEntity("http://MALL-CATEGORY-SERVICE/category/" + id, Category.class).getBody();
    //}
    //
    //private Category getCategoryFallback(Long id) {
    //    // throw new ServiceUnavailableException("MALL-CATEGORY-SERVICE");
    //    logger.error("MALL-CATEGORY-SERVICE unavailable");
    //    return new Category();
    //}
    //
    //@HystrixCommand(fallbackMethod = "getCarousels")
    //public List<Carousel> getCarousels(String usedFor) {
    //    return restTemplate.getForEntity("http://MALL-CAROUSEL-SERVICE/carousels?usedFor=" + usedFor, List.class).getBody();
    //}
    //
    //private List<Carousel> getCarousels() {
    //    logger.error("MALL-CAROUSEL-SERVICE unavailable");
    //    return new ArrayList<>();
    //}

}
