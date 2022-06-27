package chmin.newcabinet.web;

import chmin.newcabinet.domain.Product.Product;
import chmin.newcabinet.domain.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    /**
     * URL 설계
     * 기본적인 CRUD 기능 구현이 목표
     * <p>
     * GET /products : 전체 상품 조회
     * <p>
     * GET /products/{productId} : 선택 상품 조회
     * DELETE /products/{porductId} : 선택 상품 삭제
     * <p>
     * GET /products/add : 상품 추가 폼 로드
     * POST /products/add : 상품 추가 로직
     * <p>
     * GET /products/{productId}/edit : 상품 수정 폼 로드
     * POST /products/{productId}/edit : 상품 수정 로직
     * <p>
     * 렌더링할 뷰 추가 필요
     */

    // 전체 상품 조회
    @GetMapping
    public String products(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "get all products";
    }

    // 선택 상품 조회
    @GetMapping("/{productId}")
    public String showProduct(@PathVariable Long productId, Model model) {
        Product findProduct = productRepository.findById(productId);

        model.addAttribute("product", findProduct);

        return "show the product";
    }

    // 선택 상품 삭제
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId, Model model) {
        productRepository.deleteById(productId);

        return "redirect: get all products";
    }

    // 상품 추가 폼 로드
    @GetMapping("/add")
    public String addForm() {
        return "add form lender";
    }

    // 상품 추가 로직
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect: get all products";
    }

    // 상품 수정 폼 로드
    @GetMapping("/{productId}/edit")
    public String editForm(@PathVariable Long productId, Model model) {
        Product findProduct = productRepository.findById(productId);
        model.addAttribute("product", findProduct);
        return "edit form";
    }

    // 상품 수정 로직
    @PostMapping("/{productId}/edit")
    public String edit(@PathVariable Long productId, @ModelAttribute Product product) {
        productRepository.update(productId, product);
        return "redirect: get all products";
    }
}
