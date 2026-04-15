package com.example.universityeventapp

object SampleData {
    val events = listOf(
        Event(1, "AI & Robotics Summit 2026", "Jun 5, 2026", "9:30 AM", "Innovation Hub, Block C", "Tech",
            "Explore the frontiers of artificial intelligence and robotics at this flagship summit. Industry pioneers and academic researchers will present breakthroughs in autonomous systems, computer vision, and generative AI. Attendees will get hands-on experience with live robot demonstrations, AI-powered tools, and interactive lab sessions. Certificates of participation will be awarded to all registered attendees.",
            600.0, 180, 120, R.color.banner_bg1,
            "Prof. Ananya Biswas"),
        Event(2, "Web Dev Bootcamp", "Jun 12, 2026", "10:00 AM", "CS Lab Block A", "Tech",
            "A full-day immersive bootcamp covering modern web development from frontend to backend. Topics include React, Node.js, REST APIs, and deployment on cloud platforms. Beginners and intermediate developers are both welcome. Mentors from leading software companies will guide participants through real-world project building. All participants receive course materials and a completion badge.",
            0.0, 120, 85, R.color.banner_bg2,
            "Engr. Fahim Shahriar"),
        Event(3, "Basketball League Finals", "May 28, 2026", "4:00 PM", "Indoor Stadium", "Sports",
            "The most thrilling showdown of the academic year arrives as eight departmental teams clash in the Basketball League Finals. After weeks of intense qualifying rounds, the top two teams will battle for the championship title. Cheer for your team in an electrifying atmosphere with live commentary, cheerleaders, and halftime performances. Refreshment counters will be open throughout the event.",
            80.0, 600, 380, R.color.banner_bg3,
            "Coach Mainul Haque"),
        Event(4, "Badminton Open Championship", "May 18, 2026", "2:00 PM", "Sports Hall, Gym Block", "Sports",
            "Rackets are ready for the Badminton Open Championship! Singles and doubles categories are open to all university students. Over 60 players have registered from 12 departments. Watch lightning-fast rallies and powerful smashes as competitors vie for gold, silver, and bronze medals. Spectator galleries will be open to all students with free entry.",
            50.0, 200, 140, R.color.banner_bg5,
            "Mr. Sadeq Rahman"),
        Event(5, "Photography Exhibition 2026", "Jun 8, 2026", "11:00 AM", "Art Gallery, Admin Block", "Cultural",
            "Step into a visual journey curated by the Photography Club. Over 200 photographs across categories — portrait, landscape, street, and abstract — will be displayed across three gallery halls. Professional photographers from the media industry will judge entries and award prizes. Visitors can vote for the People's Choice Award. The exhibition runs for three days.",
            120.0, 250, 160, R.color.banner_bg6,
            "Ms. Laboni Sarkar"),
        Event(6, "Music & Drama Showcase", "Jun 20, 2026", "6:30 PM", "Open Amphitheater", "Cultural",
            "Witness an unforgettable evening of student talent at the annual Music & Drama Showcase. The program features original musical compositions, one-act plays, spoken word poetry, and fusion dance performances. Groups from every department have been rehearsing for months to deliver their best. The night concludes with a grand finale featuring our university choir and band performing together.",
            250.0, 400, 280, R.color.banner_bg8,
            "Mr. Rafiq-ul Islam"),
        Event(7, "Research Paper Symposium", "May 22, 2026", "9:00 AM", "Conference Room B, Research Block", "Academic",
            "The annual Research Paper Symposium provides undergraduate and postgraduate students a platform to present their original research. Papers submitted across disciplines including engineering, sciences, humanities, and business will be evaluated by faculty panels. Top papers will be recommended for journal publication. All presenters and attendees receive a certificate of participation.",
            100.0, 300, 200, R.color.banner_bg4,
            "Dr. Sharmin Akter"),
        Event(8, "International Students Mixer", "Jun 3, 2026", "5:30 PM", "Campus Garden Pavilion", "Social",
            "A vibrant cultural exchange event welcoming students from over 20 countries studying at our university. Enjoy international cuisine stalls, flag parades, traditional costume showcases, and friendly games. Share your culture, discover others, and build friendships that last a lifetime. Live music will set the mood throughout the evening and a group photo session closes the event.",
            180.0, 150, 90, R.color.banner_bg7,
            "Ms. Yasmin Chowdhury")
    )

    val speakersMap = mapOf(
        1 to listOf(
            Speaker("Dr. Reza Karim", "Associate Professor, AI Research Lab, BUET", R.color.banner_bg1),
            Speaker("Ms. Sadia Afrin", "Machine Learning Engineer, Nvidia Asia", R.color.banner_bg2),
            Speaker("Mr. Nabil Islam", "CTO, RoboVision Technologies", R.color.banner_bg3)
        ),
        2 to listOf(
            Speaker("Engr. Tanvir Hossain", "Senior Full-Stack Developer, Shohoz", R.color.banner_bg2),
            Speaker("Ms. Puja Mondal", "Frontend Architect, Brain Station 23", R.color.banner_bg6),
            Speaker("Mr. Zubair Ahmed", "DevOps Lead, Augmedix Bangladesh", R.color.banner_bg4)
        ),
        3 to listOf(
            Speaker("Mr. Kamrul Bashar", "Bangladesh Basketball Federation Coach", R.color.banner_bg3),
            Speaker("Ms. Trina Das", "National Youth Team Captain", R.color.banner_bg5)
        ),
        4 to listOf(
            Speaker("Mr. Shafiq Uddin", "BWF Certified Badminton Umpire", R.color.banner_bg5),
            Speaker("Ms. Meghna Roy", "Junior National Badminton Champion", R.color.banner_bg6)
        ),
        5 to listOf(
            Speaker("Mr. Tariq Aziz", "Chief Photographer, Daily Star BD", R.color.banner_bg6),
            Speaker("Ms. Nipa Begum", "Documentary Filmmaker, Dhaka Art Summit", R.color.banner_bg8),
            Speaker("Mr. Imrul Kayes", "Wildlife Photographer & Author", R.color.banner_bg1)
        ),
        6 to listOf(
            Speaker("Ms. Rimjhim Bose", "Classical Vocalist & Music Director", R.color.banner_bg8),
            Speaker("Mr. Tahsin Alam", "Theatre Director, Dhaka Repertory", R.color.banner_bg3),
            Speaker("Ms. Diya Chaudhary", "Fusion Dance Choreographer", R.color.banner_bg6)
        ),
        7 to listOf(
            Speaker("Prof. Wahidur Rahman", "Dean, Faculty of Engineering & Technology", R.color.banner_bg4),
            Speaker("Dr. Farhana Haque", "Senior Research Fellow, ICT Division BD", R.color.banner_bg2),
            Speaker("Mr. Arafat Hossain", "Editor, Journal of Applied Sciences BD", R.color.banner_bg1)
        ),
        8 to listOf(
            Speaker("Ms. Olivia Nguyen", "International Student Ambassador", R.color.banner_bg7),
            Speaker("Mr. Carlos Mendez", "Cultural Exchange Coordinator", R.color.banner_bg3)
        )
    )
}
