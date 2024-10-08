package com.example.phantomtroupe

import android.graphics.Typeface
import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.phantomtroupe.databinding.ActivityDetailMemberBinding
import android.text.style.StyleSpan

class DetailMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMemberBinding

    private val heroDescriptions = mapOf(
        "Chrollo Luciifer" to """
            Personality

            Chrollo is a young man with black hair, grey eyes, a cross-shaped tattoo on his forehead, and orb-shaped earrings. He typically wears a dark purple coat with white fur and a golden St. Peter's Cross on the back, revealing his muscular build. Before leading the Phantom Troupe, he didn’t wear his coat or comb back his hair. When he met Neon Nostrade, he wore a blue blazer and concealed his tattoo. His spider tattoo, marked with "0," hasn't had its location revealed, though in the 1999 anime it's placed on his right arm.

            Skills

            Chrollo Lucilfer, the leader of the Phantom Troupe, is an exceptional fighter and a highly intelligent strategist. He is respected as the strongest fighter by the Troupe members. Chrollo can hold his own against elite assassins like Silva and Zeno Zoldyck simultaneously and won his battle against Hisoka at Heavens Arena. He combines incredible speed, agility, and reflexes in his fighting style.

            As a Specialist in Nen, his main ability is "Skill Hunter," which allows him to steal other people's Nen abilities. He can use the stolen abilities through a conjured book, but there are strict conditions for stealing these abilities. Chrollo can also use two Nen powers simultaneously with the help of a special marker.

            Additionally, Chrollo is skilled in hand-to-hand combat, weapons, and possesses great physical strength and perception. He is known for his quick thinking, emotional control, and crafting intricate strategies to defeat his opponents.
        """.trimIndent(),

        "Nobunaga Hazama" to """
            Personality

            Nobunaga, a member of the Phantom Troupe, is typically calm but can be confrontational and struggles with quick decision-making. He is friendly towards Gon and Killua, wanting to befriend them because of their similarities to his late best friend, Uvogin. Despite his cheerful past, he has become ruthless and loyal to Chrollo, participating in brutal acts like the Kurta Clan massacre. He strictly controls hostages during interrogations, executing those who disobey his warnings, and diverges from traditional samurai code by using a chained katana for ranged attacks.

            Skills

            Nobunaga is an Enhancer leaning toward Transmutation, possessing a powerful aura that intimidates others. While his overall Nen proficiency is unclear, it's likely high due to his membership in the Phantom Troupe. He has demonstrated skill in En, with a maximum range of four meters, and shows knowledge of techniques like Ten and Ren. Although his Nen ability remains unshown, Shalnark noted it could easily be replaced, and Nobunaga has also displayed proficiency in Shu.
        """.trimIndent(),

        "Feitan Portor" to """
            Personality

            Feitan is the Phantom Troupe's skilled interrogator, known for his proficiency in torture and sadistic enjoyment of inflicting pain. While he is deeply loyal to Chrollo and the Troupe, he prioritizes their survival over individual members. Feitan has a close relationship with Phinks, often competing for kills during missions, and shows trust in Shalnark's judgment. Despite his brutal nature, he once displayed kindness and care towards friends and children in Meteor City, but the gruesome death of his friend Sarasa transformed him into a vengeful figure.

            Feitan is also mysophobic, refusing to consume anything touched by others, and believes in taking rather than buying what he wants. He plays a significant role in the Troupe's activities and defense of Meteor City, demonstrating both camaraderie and a ruthless disposition. His loyalty to the Troupe is unwavering, as he engages in inhumane acts alongside his teammates, showcasing a complex character shaped by his past and the darkness he embraces.

            Skills

            Feitan is a Transmuter and a powerful Nen user known for his lethal abilities. He can simultaneously utilize multiple Nen categories, demonstrating his versatility and skill. His advanced techniques include Shu and Ko, along with the fundamental techniques of Ten, Ren, Zetsu, and Gyo.

            Feitan's primary abilities are Pain Packer and Rising Sun. After taking damage, he conjures a suit of armor that boosts his aura output and protects him. In contrast, Rising Sun allows him to transmutes his aura into scorching heat, manifesting as a miniature sun that burns his enemies. The power of this ability increases with the damage he has sustained, making it particularly deadly. While wearing his armor, Feitan is immune to the heat and has a source of oxygen, indicating a strategic design to his powers.
        """.trimIndent(),

        "Machi Komacine" to """
            Personality

            Machi is one of the coldest members of the Phantom Troupe, rarely displaying emotions but caring deeply for her comrades, particularly Pakunoda, whom she mourned after her death. Her loyalty to Chrollo is unwavering, as she would go to great lengths to protect him, even challenging other members of the Troupe when necessary. Machi is confident in her strength and possesses sharp intuition that is often trusted by her allies.

            Despite her cold demeanor, Machi has a ruthless side, demonstrated during the massacre of the Kurta Clan and in her brutal traps for Mafia members. The gruesome murder of their friend Sarasa has desensitized her to violence, showcasing the darker aspects of her character. Although she treats Hisoka as a nuisance, she shows a hint of care for him after his death. The bonds shared among the inhabitants of Meteor City are strong, with the Phantom Troupe playing a significant role in its defense.

            Skills

            Machi is a Transmuter with a dual affinity for Enhancement and is highly skilled in Nen as a member of the Phantom Troupe. She has demonstrated mastery of techniques such as Hatsu, In, Ren, Gyo, and likely Ken and Ten, along with a working command of Emission.

            Her notable Nen abilities include Nen Stitches, which allow her to sew wounds and reattach severed limbs quickly, suggesting regenerative properties, and Nen Threads, where she transmutes her aura into threads to control her targets like a puppeteer or set traps. The strength of these threads varies inversely with their length, being very strong in shorter forms, while longer threads are significantly weaker. The threads are durable and cannot be easily cut or torn but lose strength as they move away from Machi.
        """.trimIndent(),

        "Hisoka Morow" to """
            Personality

            Hisoka is a self-serving, sadomasochistic fighter driven by his desire to kill powerful opponents and experience the thrill of battle. He enjoys the thrill of combat, allowing his targets to grow stronger before killing them, viewing them as "toys" that either entertain him or are discarded if they fail to impress. His manipulative and sociopathic nature makes him an unpredictable character; while he does form attachments, like his interest in Gon and Killua, he remains indifferent to their well-being, prioritizing his amusement above all else.

            Hisoka displays a morbid attraction to strong fighters, disregarding age or gender, and vows to kill members of the Phantom Troupe after his defeat by Chrollo. Despite his violent tendencies, he can show a whimsical side, enjoying teasing his victims. He often exhibits androgynous traits and uses alluring speech patterns, adding to his unpredictable and chaotic nature, which makes him both captivating and dangerous.

            Skills

            Hisoka is a skilled Transmuter with proficiency in various Nen techniques. His primary ability, **Bungee Gum**, allows him to create sticky and elastic aura, which he can manipulate for offensive, defensive, and supplementary purposes. He can extend it over distances, attach it to targets, and use it to pull opponents towards him or create flail-like weapons. He can also detach Bungee Gum from his body, utilizing it for traps and restraining powerful enemies.

            In addition to Bungee Gum, Hisoka has mastery over **Shu** and **In**, which he combines with his abilities for effective combat strategies. He also exhibits skills in **Conjuration** through **Texture Surprise**, enabling him to alter the appearance and texture of surfaces for deception. Hisoka demonstrates a remarkable level of durability and resilience, allowing him to withstand powerful attacks without significant damage. Overall, Hisoka’s versatile Nen techniques make him a formidable opponent.
        """.trimIndent(),

        "Phinks" to """
            Personality

            Phinks is a short-tempered and ruthless member of the Phantom Troupe, known for his brash behavior and tendency to engage in conflicts, even with his comrades. He has a close partnership with Feitan and displays strong loyalty to Chrollo and the Troupe, being quick to pursue Kurapika after Chrollo's capture.

            Despite his cold-blooded nature, demonstrated by his involvement in the massacre of the Kurta Clan and the killing of innocent Greed Island players, he shows a more melancholic side following the death of Pakunoda, expressing sadness to Gon and Killua. He develops a bond with the Troupe's newest member, Kalluto Zoldyck, and shows a gentlemanly side by lending his robes to Shizuku when her clothes are damaged.

            Phinks also defends Meteor City fiercely, encouraging its disfigured inhabitants to fight against threats like the Chimera Ants, showcasing a deep connection to his hometown and its residents. Although aggressive in his youth, Sarasa notes that he has a kind heart beneath his rough exterior.

            Skills

            Phinks is an Enhancer and a skilled Nen user, proficient in at least four techniques: Zetsu, Ren, Ko, and Hatsu, with a probable ability in Ken. He has theoretical knowledge about Nen, understanding concepts like "marking" for teleportation. However, he struggles with En, finding it difficult to maintain focus and effectively use it while moving.

            **Nen Ability: Ripper Cyclotron**
            When Phinks rotates his arm clockwise, his aura accumulates in his fist with each rotation. After 15 rotations, he can deliver a punch powerful enough to destroy a Chimera Ant's resilient body, though he admits that fewer rotations would suffice, indicating difficulty in calibrating his punches.
        """.trimIndent(),

        "Shalnark" to """
            Personality

            Shalnark is a cheerful, highly intelligent, and polite member of the Phantom Troupe, often acting as a voice of reason during tense situations. He has a fondness for electronics and views those he controls with his phone as puppets. Although he has good relationships with all Troupe members, he is closest to Uvogin and demonstrates strong loyalty to Chrollo.

            Like his comrades, Shalnark is ruthless and has committed atrocities, including the massacre of the Kurta Clan. He shows little regard for his own life and views his victims as expendable puppets. Despite his cold-hearted nature, he values the lives of Shizuku and Pakunoda, considering them rare assets to the Troupe. Shalnark has also defended Meteor City alongside the Phantom Troupe against threats like the Chimera Ants, showcasing his commitment to the group and their shared bonds.

            Skills

            Shalnark is a Manipulator with a focus on Emission, possessing Nen techniques like Ten and Hatsu. His primary ability, **Black Voice**, allows him to implant an antenna in his targets, giving him complete control over their actions via his bat-shaped phone. He can control two individuals at once, including himself, and can set them to autopilot mode to follow his orders without direct intervention.

            When Shalnark uses **Autopilot Mode** by sticking an antenna into himself, he gains significant boosts in speed and strength, allowing him to take down enemies easily. However, he remains unaware of his actions while in this mode and suffers intense muscle pain afterward. This ability also prevents other Manipulators from taking control of him, adding to its effectiveness.
        """.trimIndent(),

        "Shizuku" to """
            Personality

            Shizuku is characterized as calm, aloof, and callous, often making blunt statements that offend those around her. Despite her air-headed demeanor and forgetfulness, she is extremely loyal to the Phantom Troupe and adheres to Chrollo's rules, particularly against infighting among members.

            She has friendly relationships within the group, frequently teaming up with Franklin and showing visible distress over Pakunoda's death. However, like her comrades, Shizuku is cold-blooded and ruthless, quick to kill when ordered, even for trivial reasons, such as considering killing Leorio for being too loud.

            Skills

            Shizuku is a Conjurer with the ability to materialize a vacuum cleaner named Blinky. This Nen ability allows her to suck up nonliving objects while excluding living things and Nen-based items, making it useful for erasing evidence left by the Phantom Troupe.

            Shizuku's Nen techniques include Ten, Hatsu, and Gyo, indicating her advanced skills as a Nen user. Blinky can inhale an infinite number of nonliving items, but only the last object vacuumed can be regurgitated, and Shizuku doesn't know where the others go. She can also use Blinky to remove foreign materials from living bodies and, in combat, wield it as a weapon or even exsanguinate opponents by sucking their blood from wounds. Her ability is considered rare and valuable to the Troupe.
        """.trimIndent()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan nama hero dan gambar dari intent
        val heroName = intent.getStringExtra("HERO_NAME") ?: return
        val heroImageResId = intent.getIntExtra("HERO_IMAGE", -1)

        // Set judul
        binding.titleText.text = heroName

        // Mendapatkan deskripsi
        val description = heroDescriptions[heroName] ?: "Description not found."

        // Membuat SpannableString
        val spannableDescription = SpannableString(description)

        // Daftar kata-kata yang ingin diformat
        val headings = listOf("Personality", "Skills")

        // Iterasi melalui setiap kata heading dan terapkan gaya
        for (heading in headings) {
            var startIndex = spannableDescription.indexOf(heading)
            while (startIndex != -1) {
                val endIndex = startIndex + heading.length

                // Terapkan Bold
                spannableDescription.setSpan(
                    StyleSpan(Typeface.BOLD),
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                // Terapkan Ukuran Teks Lebih Besar (misalnya 1.2 kali ukuran normal)
                spannableDescription.setSpan(
                    RelativeSizeSpan(1.2f),
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                // Cari occurrence berikutnya jika ada
                startIndex = spannableDescription.indexOf(heading, endIndex)
            }
        }

        // Set teks ke TextView
        binding.detailsText.text = spannableDescription

        // Mengatur justifikasi teks
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.detailsText.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }

        // Set gambar hero
        if (heroImageResId != -1) {
            binding.heroImage.setImageResource(heroImageResId)
        } else {
            binding.heroImage.setImageResource(R.drawable.default_image) // Gambar default opsional
        }

        // Listener untuk tombol kembali
        binding.backButton.setOnClickListener {
            finish() // Tutup aktivitas dan kembali
        }
    }
}

