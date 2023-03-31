package com.croods.ecommerce.repo.wishlist;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.croods.ecommerce.dto.wishlist.WishlistFetchFromErpDTO;
import com.croods.ecommerce.vo.wishlist.WishlistVo;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistVo, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM wishlist WHERE wishlist_id = ?1", nativeQuery = true)
	int removeProductFromWishlist(long wishlistId);

	List<WishlistVo> findByContactId(long contactId);

	@Query(value = "SELECT array_to_string(Array( select product_varient_id from wishlist where contact_id = ?1\n"
			+ "group by product_varient_id),',');",nativeQuery = true)
	String findProductVarientsIdsByContactId(long contactId);
	
	@Query(value = "select wishlist_id as wishlistId,product_id as productId,product_varient_id as productVarientId,have_variations as haveVariations,\n"
			+ "company_id as companyId,\n"
			+ "branch_id as branchId,\n"
			+ "contact_id as contactId,\n"
			+ "product_name as productName,\n"
			+ "mrp ,\n"
			+ "selling_price as sellingPrice,\n"
			+ "is_deleted as isDeleted,\n"
			+ "is_save_later as isSaveLater,\n"
			+ "product_image as productImage\n"
			+ "from wishlist where contact_id = ?1",nativeQuery = true)
	List<WishlistFetchFromErpDTO> getWishlistFetchDtoForErp(long contactId);
	

}
